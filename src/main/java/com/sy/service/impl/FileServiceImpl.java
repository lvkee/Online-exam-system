package com.sy.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sy.dao.BaseMapper;
import com.sy.dao.FileMapper;
import com.sy.dao.QuestionMapper;
import com.sy.entity.FileEntity;
import com.sy.entity.other.KeyValue;
import com.sy.service.FileService;
import com.sy.viewmodel.admin.file.FilePageRequestVM;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FileServiceImpl extends BaseServiceImpl<FileEntity> implements FileService {

    private final FileMapper fileMapper;

    @Autowired
    public FileServiceImpl(FileMapper fileMapper) {
        super(fileMapper);
        this.fileMapper = fileMapper;
    }

    @Override
    public PageInfo<FileEntity> page(FilePageRequestVM requestVM) {
        return PageHelper.startPage(requestVM.getPageIndex(), requestVM.getPageSize(), "id desc").doSelectPageInfo(() ->
                fileMapper.page(requestVM)
        );
    }

    @Override
    public List<KeyValue> selectByFilename(String fileName) {
        return fileMapper.selectByFilename(fileName);
    }
}
