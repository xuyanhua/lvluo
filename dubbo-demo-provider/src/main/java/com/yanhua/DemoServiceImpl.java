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
        Result<String> result = Result.buildFailedResult("[empty param]hello:无参数");
        LOGGER.info("[empty param]hello:无参数");
        return result;
    }

    @Override
    public Result<String> sayHello(String name) {
        Result<String> result = Result.buildSuccessResult("[single param]hello:" + name);
        LOGGER.info("[single param]hello:" + name);
        return result;
    }

    @Override
    public Result<String> sayHello(String name, Integer age) {
        Result<String> result = Result.buildSuccessResult("[double params]hello:" + name + ", your age is:" + age);
        LOGGER.info("[double params]hello:" + name + ", your age is:" + age);
        return result;
    }

    @Override
    public Result<String> sayHello(StudentBean student) {
        String name = student.getName();
        Integer age = student.getAge();
        Result<String> result = Result.buildSuccessResult("[java bean]hello:" + name + ", your age is:" + age);
        LOGGER.info("[java bean]hello:{}, your age is:", name, age);
        return result;
    }

    @Override
    public void saveStudent(StudentBean student) {
        String name = student.getName();
        Integer age = student.getAge();
        LOGGER.info("hello:{},age:{}", name, age);
    }

    @Override
    public Result<String> validStudent(Integer ageLimit, StudentBean studentBean) {
        if (ageLimit == null || ageLimit.intValue() <= 0) {
            return Result.buildFailedResult("ageLimit必须大于0");
        }
        if (studentBean == null) {
            return Result.buildFailedResult("studentBean不能为空");
        }
        Boolean validFlag = studentBean.getAge() < ageLimit;
        String msg = "[混合参数]Student:name=" + studentBean.getName() + ", age=" + studentBean.getAge() //
                + "的年龄小于" + ageLimit + "->" + validFlag.toString();
        Result<String> result = Result.buildSuccessResult(validFlag, msg);
        return result;
    }

    @Override
    public Result<ArrayList<StudentBean>> listStudentLessThanAge(Integer ageLimit, List<StudentBean> studentBeanList) {
        if (ageLimit == null || ageLimit.intValue() <= 0) {
            return Result.buildFailedResult("ageLimit必须大于0");
        }
        if (CollectionUtils.isEmpty(studentBeanList)) {
            return Result.buildFailedResult("studentBeanList不能为空");
        }
        List<StudentBean> studentBeanArrayList2 = studentBeanList.stream().filter(e -> e.getAge() < ageLimit).collect(Collectors.toList());
        ArrayList<StudentBean> list = new ArrayList<>();
        list.addAll(studentBeanArrayList2);
        Result<ArrayList<StudentBean>> result = Result.buildSuccessResult(list);
        return result;
    }
}
