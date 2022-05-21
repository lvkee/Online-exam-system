package com.sy.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sy.dao.QuestionMapper;
import com.sy.entity.Question;
import com.sy.entity.Student;
import com.sy.service.QuestionService;
import com.sy.util.Page;
import com.sy.viewmodel.admin.question.QuestionPageRequestVM;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class QuestionServiceImpl extends BaseServiceImpl<Question> implements QuestionService {

//    protected final static ModelMapper modelMapper = ModelMapperSingle.Instance();
    private final QuestionMapper questionMapper;
//    private final TextContentService textContentService;
//    private final SubjectService subjectService;

  /* @Autowired
    public QuestionServiceImpl(QuestionMapper questionMapper, TextContentService textContentService, SubjectService subjectService) {
        super(questionMapper);
        this.textContentService = textContentService;
        this.questionMapper = questionMapper;
        this.subjectService = subjectService;
    }*/

    @Autowired
    public QuestionServiceImpl(QuestionMapper questionMapper) {
        super(questionMapper);
        this.questionMapper = questionMapper;
    }

    @Override
    public void showQuestionsByPage(HttpServletRequest request, Model model) {
        String pageNow = request.getParameter("pageNow");

        Page page = null;

        List<Question> questions = new ArrayList<Question>();

        int totalCount = (int) questionMapper.selectAllCount();

        if (pageNow != null) {
            page = new Page(totalCount, Integer.parseInt(pageNow));
            questions = this.questionMapper.selectQuestions(page.getStartPos(), page.getPageSize());
        } else {
            page = new Page(totalCount, 1);
            questions = this.questionMapper.selectQuestions(page.getStartPos(), page.getPageSize());
        }
        for (Question question : questions ) {
            System.out.println(question.toString());
        }
        model.addAttribute("questions", questions);
        model.addAttribute("page", page);
    }

     @Override
    public PageInfo<Question> page(QuestionPageRequestVM requestVM) {
        return PageHelper.startPage(requestVM.getPageIndex(), requestVM.getPageSize(), "id desc").doSelectPageInfo(() ->
                questionMapper.page(requestVM)
        );
    }

/*
    @Override
    @Transactional
    public Question insertFullQuestion(QuestionEditRequestVM model, Integer userId) {
        Date now = new Date();
        Integer gradeLevel = subjectService.levelBySubjectId(model.getSubjectId());

        //题干、解析、选项等 插入
        TextContent infoTextContent = new TextContent();
        infoTextContent.setCreateTime(now);
        setQuestionInfoFromVM(infoTextContent, model);
        textContentService.insertByFilter(infoTextContent);

        Question question = new Question();
        question.setSubjectId(model.getSubjectId());
        question.setGradeLevel(gradeLevel);
        question.setCreateTime(now);
        question.setQuestionType(model.getQuestionType());
        question.setStatus(QuestionStatusEnum.OK.getCode());
        question.setCorrectFromVM(model.getCorrect(), model.getCorrectArray());
        question.setScore(ExamUtil.scoreFromVM(model.getScore()));
        question.setDifficult(model.getDifficult());
        question.setInfoTextContentId(infoTextContent.getId());
        question.setCreateUser(userId);
        question.setDeleted(false);
        questionMapper.insertSelective(question);
        return question;
    }

    @Override
    @Transactional
    public Question updateFullQuestion(QuestionEditRequestVM model) {
        Integer gradeLevel = subjectService.levelBySubjectId(model.getSubjectId());
        Question question = questionMapper.selectByPrimaryKey(model.getId());
        question.setSubjectId(model.getSubjectId());
        question.setGradeLevel(gradeLevel);
        question.setScore(ExamUtil.scoreFromVM(model.getScore()));
        question.setDifficult(model.getDifficult());
        question.setCorrectFromVM(model.getCorrect(), model.getCorrectArray());
        questionMapper.updateByPrimaryKeySelective(question);

        //题干、解析、选项等 更新
        TextContent infoTextContent = textContentService.selectById(question.getInfoTextContentId());
        setQuestionInfoFromVM(infoTextContent, model);
        textContentService.updateByIdFilter(infoTextContent);

        return question;
    }

    @Override
    public QuestionEditRequestVM getQuestionEditRequestVM(Integer questionId) {
        //题目映射
        Question question = questionMapper.selectByPrimaryKey(questionId);
        return getQuestionEditRequestVM(question);
    }

    @Override
    public QuestionEditRequestVM getQuestionEditRequestVM(Question question) {
        //题目映射
        TextContent questionInfoTextContent = textContentService.selectById(question.getInfoTextContentId());
        QuestionObject questionObject = JsonUtil.toJsonObject(questionInfoTextContent.getContent(), QuestionObject.class);
        QuestionEditRequestVM questionEditRequestVM = modelMapper.map(question, QuestionEditRequestVM.class);
        questionEditRequestVM.setTitle(questionObject.getTitleContent());

        //答案
        QuestionTypeEnum questionTypeEnum = QuestionTypeEnum.fromCode(question.getQuestionType());
        switch (questionTypeEnum) {
            case SingleChoice:
            case TrueFalse:
                questionEditRequestVM.setCorrect(question.getCorrect());
                break;
            case MultipleChoice:
                questionEditRequestVM.setCorrectArray(ExamUtil.contentToArray(question.getCorrect()));
                break;
            case GapFilling:
                List<String> correctContent = questionObject.getQuestionItemObjects().stream().map(d -> d.getContent()).collect(Collectors.toList());
                questionEditRequestVM.setCorrectArray(correctContent);
                break;
            case ShortAnswer:
                questionEditRequestVM.setCorrect(questionObject.getCorrect());
                break;
            default:
                break;
        }
        questionEditRequestVM.setScore(ExamUtil.scoreToVM(question.getScore()));
        questionEditRequestVM.setAnalyze(questionObject.getAnalyze());


        //题目项映射
        List<QuestionEditItemVM> editItems = questionObject.getQuestionItemObjects().stream().map(o -> {
            QuestionEditItemVM questionEditItemVM = modelMapper.map(o, QuestionEditItemVM.class);
            if (o.getScore() != null) {
                questionEditItemVM.setScore(ExamUtil.scoreToVM(o.getScore()));
            }
            return questionEditItemVM;
        }).collect(Collectors.toList());
        questionEditRequestVM.setItems(editItems);
        return questionEditRequestVM;
    }

    public void setQuestionInfoFromVM(TextContent infoTextContent, QuestionEditRequestVM model) {
        List<QuestionItemObject> itemObjects = model.getItems().stream().map(i ->
                {
                    QuestionItemObject item = new QuestionItemObject();
                    item.setPrefix(i.getPrefix());
                    item.setContent(i.getContent());
                    item.setItemUuid(i.getItemUuid());
                    item.setScore(ExamUtil.scoreFromVM(i.getScore()));
                    return item;
                }
        ).collect(Collectors.toList());
        QuestionObject questionObject = new QuestionObject();
        questionObject.setQuestionItemObjects(itemObjects);
        questionObject.setAnalyze(model.getAnalyze());
        questionObject.setTitleContent(model.getTitle());
        questionObject.setCorrect(model.getCorrect());
        infoTextContent.setContent(JsonUtil.toJsonStr(questionObject));
    }

    @Override
    public Integer selectAllCount() {
        return questionMapper.selectAllCount();
    }

    @Override
    public List<Integer> selectMothCount() {
        Date startTime = DateTimeUtil.getMonthStartDay();
        Date endTime = DateTimeUtil.getMonthEndDay();
        List<String> mothStartToNowFormat = DateTimeUtil.MothStartToNowFormat();
        List<KeyValue> mouthCount = questionMapper.selectCountByDate(startTime, endTime);
        return mothStartToNowFormat.stream().map(md -> {
            KeyValue keyValue = mouthCount.stream().filter(kv -> kv.getName().equals(md)).findAny().orElse(null);
            return null == keyValue ? 0 : keyValue.getValue();
        }).collect(Collectors.toList());
    }*/


}
