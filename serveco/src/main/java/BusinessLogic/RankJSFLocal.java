package BusinessLogic;

import java.util.List;

import javax.ejb.Local;

import entities.Note;
 
@Local
public interface RankJSFLocal {
	
	
	
	Note Ranksup(int i);
	Note findById(int id);
	List<Note> findAll();

}
