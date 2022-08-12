package com.example.springwebnew.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.springwebnew.mapper.employeeMapper;
import com.example.springwebnew.pojo.employee;
import com.example.springwebnew.service.employeeService;
import org.springframework.stereotype.Service;

@Service
public class employeeServiceImpl extends ServiceImpl<employeeMapper, employee> implements employeeService {
}
