package com.jbb.base.service;

import com.jbb.base.dao.jpa.LabelRepository;
import com.jbb.base.dao.mybatis.LabelMapper;
import com.jbb.base.entity.Label;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.BaseService;

import java.util.List;
import java.util.Optional;

/**
 * 标签service
 *
 * @author jbb
 * @date 2019/3/16
 */
@Service
public class LabelService extends BaseService {
    @Autowired
    private LabelRepository labelRepository;
    @Autowired
    private LabelMapper labelMapper;

    public List<Label> findAll() {
        return labelRepository.findAll();
    }

    public Label findById(String id) {
        Optional<Label> label = labelRepository.findById(id);
        return label.orElseGet(() -> new Label());
    }

    public void add(Label label) {
        label.setId(getId());
        labelRepository.save(label);
    }

    public void update(Label label) {
        labelRepository.save(label);
    }

    public void deleteById(String id) {
        labelRepository.deleteById(id);
    }

    public List<Label> findSearch(Label label) {
        return labelMapper.findSearch(label);
    }
}
