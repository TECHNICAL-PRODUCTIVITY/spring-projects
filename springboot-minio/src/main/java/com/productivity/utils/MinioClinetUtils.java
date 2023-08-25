package com.productivity.utils;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import io.minio.MinioClient;
import io.minio.ObjectWriteResponse;
import io.minio.PutObjectArgs;
import io.minio.errors.ErrorResponseException;
import io.minio.errors.InsufficientDataException;
import io.minio.errors.InternalException;
import io.minio.errors.InvalidResponseException;
import io.minio.errors.ServerException;
import io.minio.errors.XmlParserException;

@Service
public class MinioClinetUtils {

	@Autowired
	MinioClient minioClient;

	public boolean uploadFile(String bucketName, MultipartFile file) {
		
		 try {
			ObjectWriteResponse objectWriteResponse = minioClient.putObject(PutObjectArgs.builder()
			         .bucket(bucketName)
			         .object(file.getOriginalFilename())
			         .stream(file.getInputStream(), file.getSize(), -1)
			         .contentType(file.getContentType())
			         .build());
			return objectWriteResponse != null ? true : false;
		} catch (InvalidKeyException | ErrorResponseException | InsufficientDataException | InternalException
				| InvalidResponseException | NoSuchAlgorithmException | ServerException | XmlParserException
				| IllegalArgumentException | IOException e) {
			e.printStackTrace();
			return false;
		}
	}


}
