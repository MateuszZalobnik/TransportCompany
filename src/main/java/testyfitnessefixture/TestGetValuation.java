package testyfitnessefixture;

import fit.ColumnFixture;
import org.Model.Model.UserRoleEnum;
import org.Presenter.Presenter.GetValuationRequest;

import java.util.IllegalFormatCodePointException;

public class TestGetValuation extends ColumnFixture {
    public String Date;
    public int Weight;
    public String StartCity;
    public String StartCountry;
    public String StartZipCode;
    public String StartStreet;
    public String StartBlockNumber;
    public String EndCity;
    public String EndCountry;
    public String EndZipCode;
    public String EndStreet;
    public String EndBlockNumber;
    public boolean IsManualValuation;

    public String getValuation() {
        try {
            int initialNumberOfOrders = getNumberOfOrdersForClient();

            GetValuationRequest request = new GetValuationRequest();
            request.Date = this.Date;
            request.Weight = this.Weight;
            request.StartCountry = this.StartCountry;
            request.StartCity = this.StartCity;
            request.StartZipCode = this.StartZipCode;
            request.StartStreet = this.StartStreet;
            request.StartBlockNumber = this.StartBlockNumber;
            request.EndCity = this.EndCity;
            request.EndCountry = this.EndCountry;
            request.EndZipCode = this.EndZipCode;
            request.EndStreet = this.EndStreet;
            request.EndBlockNumber = this.EndBlockNumber;
            request.IsManualValuation = this.IsManualValuation;

            var price = SetUp.app.GetValuation(request);

            int newNumberOfOrders = getNumberOfOrdersForClient();

            if (request.IsManualValuation && newNumberOfOrders != initialNumberOfOrders + 1) {
                return "Błąd: liczba zamówień nie została zwiększona";
            }

            if (price == -1) {
                return "Zamówienie trafiło do wyceny";
            } else {
                return String.format("Wartość wyceny: %.2f", price);
            }
        } catch (IllegalFormatCodePointException e) {
            return "Błąd: " + e.getMessage();
        }
    }

    private int getNumberOfOrdersForClient() {
        return SetUp.app.GetOrderListByRole(UserRoleEnum.Client).length;
    }
}