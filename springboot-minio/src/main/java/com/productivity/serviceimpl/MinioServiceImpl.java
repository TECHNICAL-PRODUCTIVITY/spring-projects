package com.productivity.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.MultipartFile;

import com.productivity.constants.CommonConstants;
import com.productivity.service.MinioService;
import com.productivity.utils.MinioClinetUtils;

@Configuration
public class MinioServiceImpl implements MinioService {

	@Autowired
	MinioClinetUtils minioClinetUtils;

	@Value("${bucketName}")
	private String bucketName;

	@Override
	public String uploadFile(MultipartFile file) {

		if (minioClinetUtils.uploadFile(bucketName, file)) {
			// "redirect:/"
			return CommonConstants.FILE_UPLOADED_SUCCESSFULLY;
		}

		return "failed";
	}

}
