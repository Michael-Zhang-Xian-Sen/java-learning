import java.time.DayOfWeek;
import java.time.LocalDate;

public class CalendarTest {
	public static void main(String[] args) {
		LocalDate date = LocalDate.now();	// 获取当前日期
		int month = date.getMonthValue();	// 获取当前月份
		int today = date.getDayOfMonth();	// 获取在当前月份中，现在是第几天
		
		date = date.minusDays(today-1);		// 回到这个月的第一天
		DayOfWeek weekday = date.getDayOfWeek();	// 获取在当前星期中，现在是星期几
		int value = weekday.getValue();		// 获取代表星期几的int值
		
		System.out.println("Mon Tue Wed Thu Fri Sat Sun");
		for(int i=0;i<value-1;i++) {
			System.out.print("    ");
		}
		
		// 从这个月的第一天至最后一天，遍历这个月。
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
		
		// 末尾输出空行，避免未来输入对当前的日历造成影响
		if(date.getDayOfWeek().getValue() != 1) {
			System.out.println();
		}
	}
}
