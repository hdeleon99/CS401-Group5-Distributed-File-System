package Main;
import java.util.*;
import java.io.Serializable;
import javax.swing.JOptionPane;

public class Unhidden_Storage implements Storage, Serializable
{
	private List<File> fileList = new ArrayList<File>();
	
	public List<File> GetFileList() {return fileList;}
	
	public void AppendFileList(File file)
	{
		if (FileListContains(file)) //If "fileList" already contains the file
		{
			JOptionPane.showMessageDialog(null, "File already exists in Unhidden Storage");
			return;
		}
		fileList.add(file);
		JOptionPane.showMessageDialog(null, "successfully appended file");
	}
	public void DeleteFromFileList(String fileName, String fileType)
	{
		int location = -1; //Location of possible deletion
		for (int i = 0; i < fileList.size(); i++)
		{
			String name = fileList.get(i).GetName();
			String type = fileList.get(i).GetType();
			if (fileName.equals(name) && fileType.equals(type)) {location = i; break;}
		}
		if (location == -1) //If the file isn't apart of the file list
		{
			JOptionPane.showMessageDialog(null, "File doesn't exist in Unhidden Storage");
			return;
		}
		fileList.remove(location);
		JOptionPane.showMessageDialog(null, "Successfully deleted file");
	}
	
	public boolean FileListContains(File file)
	{
		//PrintFileList();
		for (int i = 0; i < fileList.size(); i++)
		{
			if (FileEqualsFile(file, fileList.get(i))) {return true;}
		}
		return false;
	}
	
	public File GetFile(String name, String type)
	{
		for (int i = 0; i < fileList.size(); i++)
		{
			if (fileList.get(i).GetName().equals(name) && fileList.get(i).GetType().equals(type)) {return fileList.get(i);}
		}
		return null;
	}
	
	public boolean FileEqualsFile(File file1, File file2)
	{
		String name1 = file1.GetName();
		String type1 = file1.GetType();
		String name2 = file2.GetName();
		String type2 = file2.GetType();
		
		return (name1.equals(name2) && type1.equals(type2));
	}
	
	public void PrintFileList()
	{
		for (int i = 0; i < fileList.size(); i++)
		{
			JOptionPane.showMessageDialog(null, fileList.get(i).GetName() + ' ' + fileList.get(i).GetType() + '\n');
		}
	}
}
