package sample;

import Connectivity.ConnClass;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.LocalTime;

public class ServerUserDataRequest {
    String username, name, phn, email, dob, state;
    String pop1, rap1, classical1, metal1, contemp1, folk1, romantic1, hiphop1, brostep1, regional1, band1, rock1;
    String eng1, hindi1, telugu1, harayanvi1, bihari1, punjabi1, french1, spanish1, tamil1, marathi1, guj1, raja1;
    boolean registered = false;

    ServerUserDataRequest(String username, String name, String phn, String email, String dob, String state, String pop1, String rap1, String classical1, String metal1, String folk1, String romantic1, String contemp1, String brostep1, String regional1, String hiphop1, String band1, String rock1, String eng1, String hindi1, String punjabi1, String harayanvi1, String bihari1, String telugu1, String marathi1, String guj1, String french1, String spanish1, String raja1, String tamil1) throws IOException {
        this.username = username;
        this.name = name;
        this.phn = phn;
        this.email = email;
        this.dob = dob;
        this.state = state;
        this.pop1 = pop1;
        this.rap1 = rap1;
        this.classical1 = classical1;
        this.metal1 = metal1;
        this.folk1 = folk1;
        this.romantic1 = romantic1;
        this.contemp1 = contemp1;
        this.brostep1 = brostep1;
        this.regional1 = regional1;
        this.hiphop1 = hiphop1;
        this.band1 = band1;
        this.rock1 = rock1;
        this.eng1 = eng1;
        this.hindi1 = hindi1;
        this.punjabi1 = punjabi1;
        this.harayanvi1 = harayanvi1;
        this.bihari1 = bihari1;
        this.telugu1 = telugu1;
        this.marathi1 = marathi1;
        this.guj1 = guj1;
        this.french1 = french1;
        this.spanish1 = spanish1;
        this.raja1 = raja1;
        this.tamil1 = tamil1;
    }

    boolean isFullSuccessful() throws SQLException {
        //copied definition from register user to test
        System.out.println("reached here");
        Connectivity.ConnClass connectionClass = new ConnClass();
        Connection connection = connectionClass.getConnection();
        Statement statement = connection.createStatement();
        String sql = "SELECT * FROM userdata WHERE USERID = '"+username+"' AND Name='"+name+"';";
        ResultSet resultSet = statement.executeQuery(sql);
        System.out.println(phn);
        if (resultSet.next()) {
            return false;
        }
        System.out.println("reached here also");
        System.out.println(dob);
        System.out.println(state);
        LocalDate dobb=LocalDate.parse(dob);
        sql = "INSERT INTO userdata(USERID, Name,PhoneNo,Dob,Email,State) VALUES ('"+username+"','"+name+"','"+phn+"','"+dobb+"','"+email+"','"+state+"')";
        statement = connection.createStatement();
        try {
            statement.executeUpdate(sql);
            registered = true;
        } catch (Exception e) {
            e.printStackTrace();
            registered = false;
        }

        System.out.println(registered);
        return registered;
    }
}