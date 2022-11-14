package lotto.domain;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class WinningNumber {
    private static List<Integer> winningNumber;

    public Lotto saveWinningNumber(String input){
        List<Integer> winningNumber = numberToString(input);
        Lotto winning = new Lotto(winningNumber);
        return winning;
    }
    public List<Integer> numberToString(String input){
        winningNumber = Arrays.stream(input.split(","))
                .mapToInt(Integer::parseInt)
                .boxed().collect(Collectors.toList());
        return winningNumber;
    }
    public void checkBonus(String bonus){
        validateRange(Integer.parseInt(bonus));
        validateDuplicate(Integer.parseInt(bonus),winningNumber);
    }
    private void validateRange(int bonus){
        if(bonus<1 || bonus>45)
            throw new IllegalArgumentException("[ERROR] 숫자는 1부터 45 중에서 입력하셔야 합니다.");
    }
    private void validateDuplicate(int bonus, List<Integer> winningNumber){
        if(winningNumber.contains(bonus))
            throw new IllegalArgumentException("[ERROR] 보너스 숫자는 당첨 번호와 중복되면 안됩니다.");
    }
}
