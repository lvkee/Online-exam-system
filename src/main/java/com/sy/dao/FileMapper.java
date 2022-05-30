package com.sy.dao;

import com.sy.entity.FileEntity;
import com.sy.entity.Question;
import com.sy.entity.other.KeyValue;
import com.sy.viewmodel.admin.file.FilePageRequestVM;
import com.sy.viewmodel.admin.question.QuestionPageRequestVM;

import java.util.List;

/**
 * @author chris
 * @date 2022/05/29
 */
public interface FileMapper extends BaseMapper<FileEntity> {

    /**
     * 文件分页
     * @param requestVM
     * @return
     */
    List<FileEntity> page(FilePageRequestVM requestVM);

    /**
     * 根据文件名模糊查询
     * @param fileName
     * @return
     */
    List<KeyValue> selectByFilename(String fileName);
}
