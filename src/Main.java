import net.sourceforge.jFuzzyLogic.FIS;
import net.sourceforge.jFuzzyLogic.rule.FuzzyRuleSet;


public class Main {

    public static void main(String[] args) throws Exception {
        try {
            String fileName = "src/fuzzy_light.fcl";
            int poziomNatezeniaSwiatlaLampy = 66;
            int poziomNatezeniaSwiatlaWokol = 4;
            int poziomBaterii = 87;

            FIS fis = FIS.load(fileName, false);


            FuzzyRuleSet fuzzyRuleSet = fis.getFuzzyRuleSet();
            fuzzyRuleSet.chart();


            fuzzyRuleSet.setVariable("poziom_natezenia_swiatla_lampy", poziomNatezeniaSwiatlaLampy);
            fuzzyRuleSet.setVariable("poziom_natezenia_swiatla_wokol", poziomNatezeniaSwiatlaWokol);
            fuzzyRuleSet.setVariable("poziom_baterii", poziomBaterii);

            fuzzyRuleSet.evaluate();


            fuzzyRuleSet.getVariable("zmiana_natezenia_swiatla_lampy").chartDefuzzifier(true);

            System.out.println(fuzzyRuleSet);

        } catch (ArrayIndexOutOfBoundsException ex) {
            System.out.println("Niepoprawna liczba parametrow. Przyklad: java FuzzyExample string<plik_fcl> int<poziom natezenia> int<pora dnia>");
        } catch (NumberFormatException ex) {
            System.out.println("Niepoprawny parametr. Przyklad: java FuzzyExample string<plik_fcl> int<poziom natezenia> int<pora dnia>");
        } catch (Exception ex) {
            System.out.println(ex.toString());
        }
    }
}