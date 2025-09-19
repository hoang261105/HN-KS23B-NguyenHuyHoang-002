/**
 * Lớp chứa các phương thức kiểm tra số nguyên tố
 * Số nguyên tố là số tự nhiên lớn hơn 1 và chỉ chia hết cho 1 và chính nó
 * 
 * REFACTORED VERSION - Chuyển đổi từ snake_case sang camelCase
 * 
 * Các thay đổi chính:
 * - is_prime() -> isPrime()
 * - Tham số n -> number
 * - Biến i -> divisor
 * - Tất cả tên biến đều theo chuẩn camelCase
 */
public class PrimeNumberCheckerRefactored {
    
    /**
     * Kiểm tra xem một số có phải là số nguyên tố hay không
     * 
     * @param number Số cần kiểm tra (phải là số nguyên dương)
     * @return true nếu number là số nguyên tố, false nếu không
     * 
     * Logic chi tiết:
     * 1. Kiểm tra các trường hợp đặc biệt:
     *    - Nếu number <= 1: Không phải số nguyên tố (số nguyên tố phải > 1)
     *    - Nếu number == 2: Là số nguyên tố (số nguyên tố chẵn duy nhất)
     *    - Nếu number là số chẵn và > 2: Không phải số nguyên tố
     * 
     * 2. Kiểm tra các ước số lẻ từ 3 đến sqrt(number):
     *    - Chỉ cần kiểm tra đến căn bậc hai của number vì:
     *      + Nếu number có ước số > sqrt(number), thì number cũng có ước số < sqrt(number)
     *      + Ví dụ: number = 100, sqrt(100) = 10
     *        Nếu 100 chia hết cho 20 (ước > 10), thì 100 cũng chia hết cho 5 (ước < 10)
     * 
     * 3. Tối ưu hóa:
     *    - Chỉ kiểm tra các số lẻ (bước nhảy 2) vì số chẵn > 2 không phải số nguyên tố
     *    - Dừng ngay khi tìm thấy ước số đầu tiên
     * 
     * Độ phức tạp thời gian: O(sqrt(number))
     * Độ phức tạp không gian: O(1)
     * 
     * REFACTOR: is_prime(int n) -> isPrime(int number)
     */
    public static boolean isPrime(int number) {
        // Kiểm tra trường hợp đặc biệt: số <= 1 không phải số nguyên tố
        if (number <= 1) {
            return false;
        }
        
        // Số 2 là số nguyên tố chẵn duy nhất
        if (number == 2) {
            return true;
        }
        
        // Số chẵn > 2 không phải số nguyên tố
        if (number % 2 == 0) {
            return false;
        }
        
        // Kiểm tra các ước số lẻ từ 3 đến sqrt(number)
        // Chỉ cần kiểm tra đến căn bậc hai vì nếu có ước > sqrt(number) 
        // thì cũng có ước < sqrt(number)
        for (int divisor = 3; divisor * divisor <= number; divisor += 2) {
            // Nếu tìm thấy ước số, number không phải số nguyên tố
            if (number % divisor == 0) {
                return false;
            }
        }
        
        // Nếu không tìm thấy ước số nào, number là số nguyên tố
        return true;
    }
    
    /**
     * Phương thức kiểm tra số nguyên tố với thuật toán đơn giản hơn (chậm hơn)
     * Dùng để so sánh hiệu suất với phương thức isPrime()
     * 
     * @param number Số cần kiểm tra
     * @return true nếu number là số nguyên tố, false nếu không
     * 
     * Logic:
     * - Kiểm tra tất cả số từ 2 đến number-1
     * - Nếu number chia hết cho bất kỳ số nào trong khoảng này thì không phải số nguyên tố
     * 
     * Độ phức tạp thời gian: O(number)
     * 
     * REFACTOR: isPrimeSimple(int n) -> isPrimeSimple(int number)
     * REFACTOR: biến i -> divisor
     */
    public static boolean isPrimeSimple(int number) {
        if (number <= 1) {
            return false;
        }
        
        // Kiểm tra tất cả số từ 2 đến number-1
        for (int divisor = 2; divisor < number; divisor++) {
            if (number % divisor == 0) {
                return false;
            }
        }
        
        return true;
    }
    
    /**
     * Phương thức main để test các hàm kiểm tra số nguyên tố
     * 
     * REFACTOR: Tất cả biến được đổi tên theo camelCase
     */
    public static void main(String[] args) {
        // Test với một số số nguyên tố và không phải số nguyên tố
        int[] testNumbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47};
        
        System.out.println("Kiểm tra số nguyên tố (Refactored Version):");
        System.out.println("Số\tisPrime()\tisPrimeSimple()");
        System.out.println("--------------------------------");
        
        for (int testNumber : testNumbers) {
            boolean resultOptimized = isPrime(testNumber);
            boolean resultSimple = isPrimeSimple(testNumber);
            System.out.printf("%d\t%s\t\t%s%n", testNumber, resultOptimized, resultSimple);
        }
        
        // Test hiệu suất với số lớn
        System.out.println("\nTest hiệu suất với số lớn:");
        int largeNumber = 1000003; // Số nguyên tố lớn
        
        long startTime = System.nanoTime();
        boolean resultOptimized = isPrime(largeNumber);
        long endTime = System.nanoTime();
        long timeOptimized = endTime - startTime;
        
        startTime = System.nanoTime();
        boolean resultSimple = isPrimeSimple(largeNumber);
        endTime = System.nanoTime();
        long timeSimple = endTime - startTime;
        
        System.out.printf("Số %d: isPrime() = %s (thời gian: %d ns)%n", largeNumber, resultOptimized, timeOptimized);
        System.out.printf("Số %d: isPrimeSimple() = %s (thời gian: %d ns)%n", largeNumber, resultSimple, timeSimple);
        System.out.printf("isPrime() nhanh hơn isPrimeSimple() %.2f lần%n", (double)timeSimple / timeOptimized);
        
        // Hiển thị thông tin refactor
        System.out.println("\n=== THÔNG TIN REFACTOR ===");
        System.out.println("Các thay đổi chính:");
        System.out.println("- is_prime() -> isPrime()");
        System.out.println("- Tham số n -> number");
        System.out.println("- Biến i -> divisor");
        System.out.println("- Tất cả tên biến đều theo chuẩn camelCase");
    }
}
