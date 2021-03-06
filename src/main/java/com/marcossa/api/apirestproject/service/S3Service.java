package com.marcossa.api.apirestproject.service;

import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URISyntaxException;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.marcossa.api.apirestproject.service.exception.FileException;

@Service
public class S3Service {

	private Logger LOG = org.slf4j.LoggerFactory.getLogger(S3Service.class);

	@Autowired
	private AmazonS3 s3cliente;

	@Value("${s3.bucket}")
	private String bucketName;

	public URI uploadFile(MultipartFile multipartfile) {
		try {
			String fileName = multipartfile.getOriginalFilename();
			InputStream is = multipartfile.getInputStream();
			String contentType = multipartfile.getContentType();
			return uploadFile(is, fileName, contentType);
		} catch (IOException e) {
			throw new FileException("Erro de IO: " + e.getMessage());
		}
		
	}

	public URI uploadFile(InputStream is, String fileName, String contentType) {
		try {
			ObjectMetadata meta = new ObjectMetadata();
			meta.setContentType(contentType);
			LOG.info("Iniciando Upload!");
			s3cliente.putObject(bucketName, fileName, is, meta);
			LOG.info("Upload feito com sucesso!");
			return s3cliente.getUrl(bucketName, fileName).toURI();
		} catch (URISyntaxException e) {
			throw new FileException("Erro ao converter URL para URI");
		}
	}
}
