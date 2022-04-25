
public class Hidden_Storage implements Storage
{
	private File[] fileList = new File[7]; //Base line storage is 7
	private int numFiles = 0;
	
	public File[] GetFileList() {return fileList;}
	
	public void AppendFileList(File file)
	{
		if (FileListContains(file)) {return;} //If "fileList" already contains the file
		if (numFiles == fileList.length) //If "fileList" is full, double it's size
		{
			File tmp[] = new File[2 * numFiles];
		    System.arraycopy(fileList, 0, tmp, 0, numFiles); 
		    fileList = tmp;
		    tmp = null;
		}
		fileList[numFiles] = file;
		++numFiles;
	}
	
	public void DeleteFromFileList(String fileName, String fileType)
	{
		int location = -1;; //Location of possible deletion
		for (int i = 0; i < numFiles; i++)
		{
			String name = fileList[i].GetName();
			String type = fileList[i].GetType();
			if (fileName.equals(name) && fileType.equals(type)) {location = i; break;}
		}
		if (location == -1) {return;} //If the file isn't apart of the file list
		for (int i = location; i < numFiles - 1; i++) {fileList[i] = fileList[i + 1];} //Delete this user from list
		--numFiles;
	}
	
	public boolean FileListContains(File file)
	{
		for (int i = 0; i < numFiles; i++)
		{
			if (FileEqualsFile(file, fileList[i])) {return true;}
		}
		return false;
	}
	
	private boolean FileEqualsFile(File file1, File file2)
	{
		String name1 = file1.GetName();
		String type1 = file1.GetType();
		String name2 = file2.GetName();
		String type2 = file2.GetType();
		
		if (name1.equals(name2) && type1.equals(type2)) {return true;}
		return false;
	}
	
	public int GetNumFiles() {return numFiles;}
}