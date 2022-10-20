package ex00;
import java.util.HashMap;
import java.io.*;
import java.util.ArrayList;
 

public class FileFinder {
	
	private HashMap<StringBuilder, String> signatures;
	private ArrayList<String> lines;

	FileFinder() {
		signatures = new HashMap<>();
		lines = new ArrayList<>();
	}

	public boolean readFile(String path) {
        try (FileInputStream fileInputStream = new FileInputStream(path)) {
            while (fileInputStream.available() != 0) {
                lines.add(readLine(fileInputStream));
            }
			
        } catch (IOException e) {
            return false;
        }
        return true;
    }

	private String readLine(FileInputStream fileInputStream) throws IOException {
        
		StringBuilder str = new StringBuilder();

        int c;
        while ((c = fileInputStream.read()) != -1 && (char) c != '\n') {
            if (c >= 'a' && c <= 'f') {
                c = c - 'a' + 'A';
            }
            str.append((char) c);
        }
        return new String(str.toString());
    }
	


	
	public String findType(String filePath){
		if (fileItdentity(filePath) != null)

		return "";
	}

}

//reading from file
	public String fileItdentity(String path) {
		byte bytes[] = new byte[8];

		try (FileInputStream fileInputStream = new FileInputStream(path)) {
			if (fileInputStream.read(bytes) == -1) {
				return null;
			}
		}
		catch (IOException e) {
			return null;
		}


		// for (StringForReading s : strings) {
		// 	boolean isFind = true;
		// 	List<Byte> hex = s.getHex();
		// 	for (int i = 0; i < hex.size(); i++) {
		// 		if (bytes[i] != hex.get(i)) {
		// 			isFind = false;
		// 			break;
		// 		}
		// 	}
		// 	if (isFind) {
		// 		return s.getFileFormat();
		// 	}
		// }
		return null;
	}	
// }







//     public String qualify(String path) {
//         byte bytes[] = new byte[8];

//         try (FileInputStream fileInputStream = new FileInputStream(path)) {
//             if (fileInputStream.read(bytes) == -1) {
//                 return null;
//             }
//         } catch (IOException e) {
//             return null;
//         }

//         for (Line l : lines) {
//             boolean isFind = true;
//             List<Byte> hex = l.getHex();
//             for (int i = 0; i < hex.size(); i++) {
//                 if (bytes[i] != hex.get(i)) {
//                     isFind = false;
//                     break;
//                 }
//             }
//             if (isFind) {
//                 return l.getFormat();
//             }
//         }
//         return null;
//     }
// }