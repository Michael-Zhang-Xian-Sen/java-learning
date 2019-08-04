import java.time.DayOfWeek;
import java.time.LocalDate;

public class CalendarTest {
	public static void main(String[] args) {
		LocalDate date = LocalDate.now();	// ��ȡ��ǰ����
		int month = date.getMonthValue();	// ��ȡ��ǰ�·�
		int today = date.getDayOfMonth();	// ��ȡ�ڵ�ǰ�·��У������ǵڼ���
		
		date = date.minusDays(today-1);		// �ص�����µĵ�һ��
		DayOfWeek weekday = date.getDayOfWeek();	// ��ȡ�ڵ�ǰ�����У����������ڼ�
		int value = weekday.getValue();		// ��ȡ�������ڼ���intֵ
		
		System.out.println("Mon Tue Wed Thu Fri Sat Sun");
		for(int i=0;i<value-1;i++) {
			System.out.print("    ");
		}
		
		// ������µĵ�һ�������һ�죬��������¡�
		while(date.getMonthValue() == month) {
			System.out.printf("%3d",date.getDayOfMonth());
			if(date.getDayOfMonth() == today) {
				System.out.print("*");
			}else {
				System.out.print(" ");
			}
			date = date.plusDays(1);
			if(date.getDayOfWeek().getValue() == 1) {
				System.out.println();
			}
		}
		
		// ĩβ������У�����δ������Ե�ǰ���������Ӱ��
		if(date.getDayOfWeek().getValue() != 1) {
			System.out.println();
		}
	}
}