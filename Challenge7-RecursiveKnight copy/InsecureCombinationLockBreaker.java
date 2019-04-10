//UIUC CS125 SPRING 2017 MP. File: InsecureCombinationLockBreaker.java, CS125 Project: Challenge7-RecursiveKnight, Version: 2017-04-11T09:33:02-0500.466225000
//@author mapope2
public class InsecureCombinationLockBreaker {

	public static int breakLock(InsecureCombinationLock lock) {
		int multiplier = 1;
		int testValue = 0;
		while (multiplier < 1000000000)
		{
			String returnValue = lock.open(testValue);
			String returnValue1 = lock.open(testValue + 1 * multiplier);
			String returnValue2 = lock.open(testValue + 2 * multiplier);
			char char0 = returnValue.charAt(0);
			char char1 = returnValue1.charAt(0);
			char char2 = returnValue2.charAt(0);
			//Case 1 - All of the three values are equal
			if (char0 == char1 && char1 == char2) 
			{
				String returnValueI = returnValue2;
				int i = 3;
				for (; returnValueI.charAt(0) == char1; i++)
				{
					returnValueI = lock.open(testValue + i * multiplier);
				}
				testValue += (i - 1) * multiplier; //i will be one too big otherwise
			}
			//Case 3 - char1 is different
			if (char0 != char1 && char0 == char2)
				testValue += multiplier;
			//Case 4 - char2 is different
			if (char0 == char1 && char2 != char1)
				testValue += multiplier * 2;
			multiplier *= 10;
		}
		System.out.print(testValue);
		return testValue;
	}

	public static void main(String[] args) {
			InsecureCombinationLock lock = new InsecureCombinationLock();
			int code = breakLock(lock);
			
			System.out.println("Unlock code:"+code);
			System.out.println(lock.isUnlocked() ? "Unlocked :-)" : "Still Locked :-(");
	}
}
