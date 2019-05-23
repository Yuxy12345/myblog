package com.yuxy.myblog.service.type;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.yuxy.myblog.domain.Type;
import com.yuxy.myblog.mapper.TypeDAO;

@Service
public class TypeServiceImpl implements TypeService {

	@Resource
	TypeDAO td;
	
	public List<Type> getAllTypes() {
		return td.getAllTypes();
	}

}
