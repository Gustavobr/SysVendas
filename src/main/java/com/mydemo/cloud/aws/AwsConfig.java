package com.mydemo.cloud.aws;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.core.io.WritableResource;

public class AwsConfig {

	@Autowired

	ResourceLoader resourceLoader;
	private File downloadS3Object = null;

	// class Files, Arrays, Paths.

	/* Upload */

	public void uploadFIletoS3(File file, String s3Url) throws IOException {
		WritableResource resource = /* Cast */ (WritableResource) resourceLoader.getResource(s3Url);

		try (OutputStream outputStream = resource.getOutputStream()) {
			Files.copy(file.toPath(), outputStream);
		}
	}

	public void downloadS3Object(String s3Url) throws IOException {
		 Resource resource = resourceLoader.getResource(s3Url);
		    File downloadedS3Object =  new File(resource.getFilename());
			
				try	(InputStream input = resource.getInputStream()){	
						Files.copy(input, downloadS3Object.toPath(),
						StandardCopyOption.REPLACE_EXISTING);
					
						
				
			}
		
		
	}

}
