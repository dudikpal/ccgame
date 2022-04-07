package hobby.ccgame.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CardDTO {

    private DataDTO id = new DataDTO <String>("ID", null);

    private DataDTO manufacturer = new DataDTO <String>("Manufacturer", null);

    private DataDTO type = new DataDTO <String>("Car type", null);

    private DataDTO year = new DataDTO <Integer>("Year", null);

    private DataDTO country = new DataDTO <String>("Country", null);

    private DataDTO doors = new DataDTO <Integer>("Doors", null);

    private DataDTO body = new DataDTO <String>("Body type", null);

    private DataDTO seats = new DataDTO <Integer>("Seats", null);

    private DataDTO driveWheel = new DataDTO <String>("Drive wheel", null);

    private DataDTO fuelType = new DataDTO <String>("Fuel type", null);

    private DataDTO fuelTankCapacity = new DataDTO <Integer>("Fuel tank (lit.)", null);

    private DataDTO engineCapacity = new DataDTO <Integer>("Engine capacity (cm<sup>3</sup>)", null);

    private DataDTO powerKW = new DataDTO <Integer>("Power (KW)", null);

    private DataDTO powerHP = new DataDTO <Integer>("Power (HP)", null);

    private DataDTO maxTorque = new DataDTO <Integer>("Max Torque (Nm)", null);

    private DataDTO topSpeed = new DataDTO <Integer>("Top speed (km/h)", null);

    private DataDTO acceleration = new DataDTO <Double>("0-100 km/h (sec)", null);

    private DataDTO weight = new DataDTO <Integer>("Weight (kg)", null);

    private DataDTO length = new DataDTO <Integer>("Length (mm)", null);

    private DataDTO width = new DataDTO <Integer>("Width (mm)", null);

    private DataDTO height = new DataDTO <Integer>("Height (mm)", null);

    private DataDTO groundClearance = new DataDTO <Integer>("Ground clearence (mm)", null);

    private DataDTO abs = new DataDTO <String>("ABS", null);

    private DataDTO tractionControl = new DataDTO <String>("Traction control", null);

    private DataDTO imageUrl = new DataDTO <String>("Car image URL", null);

    private DataDTO logoURL = new DataDTO <String>("Manufacturer Logo URL", null);

    private DataDTO carPageUrl = new DataDTO <String>("Car page Url", null);

    private DataDTO objectPositionHorizontal = new DataDTO <String>("Object horizontal position", null);

    private DataDTO objectPositionVertical = new DataDTO <String>("Object vertical position", null);

    private DataDTO objectWidth = new DataDTO <String>("Object width", null);

    private DataDTO objectHeight = new DataDTO <String>("Object height", null);

    private DataDTO gear1st = new DataDTO <Double>("1st gear", null);

    private DataDTO gear2nd = new DataDTO <Double>("2nd gear", null);

    private DataDTO gear3rd = new DataDTO <Double>("3rd gear", null);

    private DataDTO gear4th = new DataDTO <Double>("4th gear", null);

    private DataDTO gear5th = new DataDTO <Double>("5th gear", null);

    private DataDTO gear6th = new DataDTO <Double>("6th gear", null);

    private DataDTO finalDrive = new DataDTO <Double>("Final drive", null);
}
