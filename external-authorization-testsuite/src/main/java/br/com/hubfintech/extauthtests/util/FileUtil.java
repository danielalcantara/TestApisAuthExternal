package br.com.hubfintech.extauthtests.util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;

import org.springframework.stereotype.Component;

@Component
public class FileUtil implements IFileUtil {

	@Override
	public InputStream getInputStreamByOutputStream(ByteArrayOutputStream outputStream) {
		byte[] bytes = outputStream.toByteArray();
		InputStream inputStream = new ByteArrayInputStream(bytes);

		return inputStream;
	}

}
