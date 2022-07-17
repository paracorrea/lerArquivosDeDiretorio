package lerArquivosDeFolder;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LerTodosArquivosDaPasta {

	public static void main(String[] args) throws IOException {
		
		List<String> result;
		
		 try (Stream<Path> walk = Files.walk(Paths.get("/home/fernando/Documentos/novo/folderFiles/nfe"))) {
		      result = walk
		              .filter(p -> !Files.isDirectory(p))   // not a directory
		              .map(p -> p.getFileName().toString().toLowerCase()) // convert path to string
		              .filter(f -> f.endsWith("xml"))       // check end with
		              .collect(Collectors.toList());        // collect all matched to a List
		  }
	
		 
		for (String string : result) {
			
			String head = string.substring(0, 5);
			
			//System.out.println(string);
			System.out.println(head);
		} 
		
		}
	}


