package com.yjz.mp.demo.person.service.impl;

import com.yjz.mp.demo.person.entity.Person;
import com.yjz.mp.demo.person.mapper.PersonMapper;
import com.yjz.mp.demo.person.service.PersonService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Honyelchak
 * @since 2020-03-21
 */
@Service
public class PersonServiceImpl extends ServiceImpl<PersonMapper, Person> implements PersonService {

}
