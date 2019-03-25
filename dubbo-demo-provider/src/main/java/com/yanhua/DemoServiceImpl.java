package com.yanhua;

import org.apache.commons.collections4.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author xuyanhua
 * @description:
 * @date 2019/3/22 下午2:39
 */
public class DemoServiceImpl implements DemoService {

    private final static Logger LOGGER = LoggerFactory.getLogger(DemoServiceImpl.class);

    @Override
    public Result<String> sayHello() {
        Result<String> result = new Result<>();
        result.setModule("[empty param]hello:无参数");
        LOGGER.info("[empty param]hello:无参数");
        return result;
    }

    @Override
    public Result<String> sayHello(String name) {
        Result<String> result = new Result<>();
        result.setModule("[single param]hello:" + name);
        LOGGER.info("[single param]hello:" + name);
        return result;
    }

    @Override
    public Result<String> sayHello(String name, Integer age) {
        Result<String> result = new Result<>();
        result.setModule("[double params]hello:" + name + ", your age is:" + age);
        LOGGER.info("[double params]hello:" + name + ", your age is:" + age);
        return result;
    }

    @Override
    public Result<String> sayHello(StudentBean student) {
        String name = student.getName();
        Integer age = student.getAge();
        Result<String> result = new Result<>();
        result.setModule("[java bean]hello:" + name + ", your age is:" + age);
        LOGGER.info("[java bean]hello:" + name + ", your age is:" + age);
        return result;
    }

    @Override
    public void saveStudent(StudentBean student) {
        String name = student.getName();
        Integer age = student.getAge();
        System.out.println("hello:" + name);
        Result<String> result = new Result<>();
        result.setModule("[no response]saveStudent:name=" + name + ", age=" + age);
    }

    @Override
    public Result<ArrayList<StudentBean>> listStudentLessThanAge(Integer ageLimit, List<StudentBean> studentBeanList) {
        if (ageLimit == null || ageLimit.intValue() <= 0) {
            return Result.buildFailedResult("ageLimit必须大于0");
        }
        if (CollectionUtils.isEmpty(studentBeanList)) {
            return Result.buildFailedResult("studentBeanList不能为空");
        }
        Result<ArrayList<StudentBean>> result = new Result<>();
        List<StudentBean> studentBeanArrayList2 = studentBeanList.stream().filter(e ->
                e.getAge() > ageLimit
        ).collect(Collectors.toList());
        ArrayList<StudentBean> list = new ArrayList<>();
        list.addAll(studentBeanArrayList2);
        result.setModule(list);
        return result;
    }


}
