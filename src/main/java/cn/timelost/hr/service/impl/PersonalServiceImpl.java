package cn.timelost.hr.service.impl;

import cn.timelost.hr.dao.PersonalDao;
import cn.timelost.hr.enums.ResultEnum;
import cn.timelost.hr.exception.BaseException;
import cn.timelost.hr.pojo.Personal;
import cn.timelost.hr.service.DepartmentService;
import cn.timelost.hr.service.PersonalService;
import cn.timelost.hr.service.PositionService;
import cn.timelost.hr.vo.PersonalVo;
import cn.timelost.hr.vo.input.PersonalForm;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import javax.annotation.Resource;
import java.util.Collection;
import java.util.List;

/**
 * @author: Jyf
 * @Date: 2021/1/28 17:51
 */
@Service
public class PersonalServiceImpl implements PersonalService {

    @Resource
    PersonalDao personalDao;
    @Resource
    DepartmentService departmentService;
    @Resource
    PositionService positionService;

    @Override
    public PageInfo<PersonalVo> findAll(int pageNum, int pageSize, int departmentId) {
        PageHelper.startPage(pageNum, pageSize);
        List<PersonalVo> personals = personalDao.selectAllByDepartmentId(departmentId);
        return new PageInfo<>(personals);
    }

    @Override
    public PageInfo<PersonalVo> search(String personalName, int pageNum, int pageSize) {
        if (ObjectUtils.isEmpty(personalName)) {
            throw new BaseException(ResultEnum.PERSONAL_NOT_EXIST);
        }
        PageHelper.startPage(pageNum, pageSize);
        List<PersonalVo> personalVos = personalDao.selectAllByNameLike(personalName);
        return new PageInfo<>(personalVos);
    }

    @Override
    public PersonalVo find(int id) {
        Personal personal = personalDao.selectByPrimaryKey(id);
        if (ObjectUtils.isEmpty(personal)) {
            throw new BaseException(ResultEnum.PERSONAL_NOT_EXIST);
        }
        PersonalVo personalVo = new PersonalVo();
        BeanUtils.copyProperties(personal, personalVo);
        return personalVo;
    }

    @Override
    public void insert(PersonalForm personalForm) {
        if (!ObjectUtils.isEmpty(personalForm.getDepartmentId())) {
            departmentService.find(personalForm.getDepartmentId());
        }
        if (!ObjectUtils.isEmpty(personalForm.getPositionId())) {
            positionService.find(personalForm.getPositionId());
        }
        Personal personal = new Personal();
        BeanUtils.copyProperties(personalForm, personal);
        personalDao.insertSelective(personal);
    }

    @Override
    public void deleteById(Integer id) {
        Personal personal = personalDao.selectByPrimaryKey(id);
        if (ObjectUtils.isEmpty(personal)) {
            throw new BaseException(ResultEnum.PERSONAL_NOT_EXIST);
        }
        personalDao.deleteByPrimaryKey(id);
    }

    @Override
    public void deleteByIdIn(Collection<Integer> idList) {
        personalDao.deleteByIdIn(idList);
    }

    @Override
    public void updateById(Integer id, PersonalForm personalForm) {
        Personal personal = personalDao.selectByPrimaryKey(id);
        if (ObjectUtils.isEmpty(personal)) {
            throw new BaseException(ResultEnum.POSITION_NOT_EXIST);
        }
        BeanUtils.copyProperties(personalForm, personal);
        personal.setId(id);
        personalDao.updateByPrimaryKeySelective(personal);
    }
}