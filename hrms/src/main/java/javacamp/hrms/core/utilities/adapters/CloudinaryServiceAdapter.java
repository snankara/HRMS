package javacamp.hrms.core.utilities.adapters;

import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;

import javacamp.hrms.core.utilities.abstracts.CloudinaryImageService;
import javacamp.hrms.core.utilities.results.DataResult;
import javacamp.hrms.core.utilities.results.ErrorDataResult;
import javacamp.hrms.core.utilities.results.SuccessDataResult;

@Service
public class CloudinaryServiceAdapter implements CloudinaryImageService{

	private Cloudinary cloudinary;
	
	public CloudinaryServiceAdapter () {
		this.cloudinary = new Cloudinary(ObjectUtils.asMap(
				"cloud_name", "dkdjjqjgf",
				"api_key", "622266391466245",
				"api_secret", "EEZ-3UuyXn7QfUC_y7YnnnZbido"));
	}
	
	@Override
	public DataResult<Map> uploadImage(MultipartFile image) {
		try {
			@SuppressWarnings("unchecked")
			Map<String, String> result = (Map<String, String>) cloudinary.uploader().upload(image.getBytes(), ObjectUtils.emptyMap());
			return new SuccessDataResult<Map>(result);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ErrorDataResult<Map>();
	}

}
