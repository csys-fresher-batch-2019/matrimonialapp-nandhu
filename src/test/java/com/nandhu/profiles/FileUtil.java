package com.nandhu.profiles;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileUtil {
		public static void WriteToFile(String FileName,String FileContent)throws IOException
		{
			Path path=Paths.get(FileName);
			byte[] bytes=FileContent.getBytes();
			Files.write(path, bytes);
			
	}
}


