/**
 * Lớp chứa các phương thức kiểm tra số nguyên tố
 * Số nguyên tố là số tự nhiên lớn hơn 1 và chỉ chia hết cho 1 và chính nó
 */
public class PrimeNumberChecker {
    public static boolean is_prime(int n) {
        // Kiểm tra trường hợp đặc biệt: số <= 1 không phải số nguyên tố
        if (n <= 1) {
            return false;
        }
        
        // Số 2 là số nguyên tố chẵn duy nhất
        if (n == 2) {
            return true;
        }
        
        // Số chẵn > 2 không phải số nguyên tố
        if (n % 2 == 0) {
            return false;
        }
        
        // Kiểm tra các ước số lẻ từ 3 đến sqrt(n)
        // Chỉ cần kiểm tra đến căn bậc hai vì nếu có ước > sqrt(n) 
        // thì cũng có ước < sqrt(n)
        for (int i = 3; i * i <= n; i += 2) {
            // Nếu tìm thấy ước số, n không phải số nguyên tố
            if (n % i == 0) {
                return false;
            }
        }
        
        // Nếu không tìm thấy ước số nào, n là số nguyên tố
        return true;
    }

    public static boolean isPrimeSimple(int n) {
        if (n <= 1) {
            return false;
        }
        
        // Kiểm tra tất cả số từ 2 đến n-1
        for (int i = 2; i < n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        
        return true;
    }
}
