package uploadFile;



public class ExamBean {
private int examId;
private String start;
private String end ;
private int AbilityToDoExam; // 0 can do the exam , other wise can not do the exam
private int QuestionsNo;

private SubjectBean subject;
private login.LoginBean log;
public SubjectBean getSubject() {
	return subject;
}
public void setSubject(SubjectBean subject) {
	this.subject = subject;
}
public login.LoginBean getLog() {
	return log;
}
public void setLog(login.LoginBean log) {
	this.log = log;
}

public int getExamId() {
	return examId;
}
public void setExamId(int examId) {
	this.examId = examId;
}
public String getStart() {
	return start;
}
public void setStart(String start) {
	this.start = start;
}
public String getEnd() {
	return end;
}
public void setEnd(String end) {
	this.end = end;
}

public int getAbilityToDoExam() {
	return AbilityToDoExam;
}
public void setAbilityToDoExam(int abilityToDoExam) {
	AbilityToDoExam = abilityToDoExam;
}
public int getQuestionsNo() {
	return QuestionsNo;
}
public void setQuestionsNo(int questionsNo) {
	QuestionsNo = questionsNo;
}
}
