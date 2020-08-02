package com.xiaoshu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.github.pagehelper.util.StringUtil;
import com.xiaoshu.dao.DeviceMapper;
import com.xiaoshu.dao.DevicetypeMapper;
import com.xiaoshu.dao.UserMapper;
import com.xiaoshu.entity.Device;
import com.xiaoshu.entity.DeviceExample;
import com.xiaoshu.entity.DeviceExample.Criteria;
import com.xiaoshu.entity.Devicetype;
import com.xiaoshu.entity.User;


@Service
public class DeviceService {

	@Autowired
	private DeviceMapper dm;
	
	@Autowired
	private DevicetypeMapper dsm;
	
	public PageInfo<Device> findDevicePage(int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		
		List<Device> deviceList = dm.queryAllDevice();
		PageInfo<Device> pageInfo = new PageInfo<Device>(deviceList);
		return pageInfo;
	}
	// 新增
	public void addDevice(Device device) throws Exception {
		dm.insert(device);
	};
	// 修改
	public void updateDevice(Device d) throws Exception {
		dm.updateByPrimaryKeySelective(d);
	};

	// 删除
	public void deleteDevice(Integer devicetypeid) throws Exception {
		dm.deleteByPrimaryKey(devicetypeid);
	}
	public List<Devicetype> finAlldevicetype() {
		// TODO Auto-generated method stub
		return dsm.selectAll();
	};
	// 通过用户名判断是否存在，（新增时不能重名）
		public Device existUserWithUserName(String userName) throws Exception {
			DeviceExample example = new DeviceExample();
			Criteria criteria = example.createCriteria();
			criteria.andDevicenameEqualTo(userName);
			List<Device> userList = dm.selectByExample(example);
			return userList.isEmpty()?null:userList.get(0);
		};
}
