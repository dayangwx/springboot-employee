package com.example.springwebnew.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.springwebnew.mapper.departmentMapper;
import com.example.springwebnew.pojo.department;
import com.example.springwebnew.service.departmentService;
import org.springframework.stereotype.Service;

@Service
public class departmentServiceImpl extends ServiceImpl<departmentMapper, department> implements departmentService {
}
