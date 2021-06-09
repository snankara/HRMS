package javacamp.hrms.core.utilities.abstracts;

import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

import javacamp.hrms.core.utilities.results.DataResult;

public interface CloudinaryImageService {
	DataResult<Map> uploadImage(MultipartFile image);
}
