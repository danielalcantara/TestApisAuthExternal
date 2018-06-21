package br.com.hubfintech.extauthtests.util;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

public interface IFileUtil {

	public InputStream getInputStreamByOutputStream(ByteArrayOutputStream outputStream) throws IOException;

}
