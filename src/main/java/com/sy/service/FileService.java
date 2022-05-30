package com.sy.service;

import com.github.pagehelper.PageInfo;
import com.sy.entity.FileEntity;
import com.sy.entity.Question;
import com.sy.entity.other.KeyValue;
import com.sy.viewmodel.admin.file.FilePageRequestVM;
import com.sy.viewmodel.admin.question.QuestionEditRequestVM;

import java.util.List;

/**
 *
 * @author chris
 */
public interface FileService extends BaseService<FileEntity> {

    /**
     * 文件分页
     * @param requestVM
     * @return
     */
    PageInfo<FileEntity> page(FilePageRequestVM requestVM);

    /**
     * 根据文件名模糊查询
     * @param fileName
     * @return
     */
    List<KeyValue> selectByFilename(String fileName);

}
