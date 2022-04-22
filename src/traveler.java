
/*
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import java.net.URLEncoder;
*/
import java.sql.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class traveler extends JFrame{
    //private static final long serialVersionUID = 2451829341034438685L;


    public traveler() {
      /*
        try {

            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
            //Connection con = DriverManager.getConnection("jdbc:odbc:[B]app[/B]");
           // Connection conn=DriverManager.getConnection("jdbc:ucanaccess://C:\\Downloads\\app.xlsx");
            //Statement s = conn.createStatement();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("Select * from [Gurit DB$]");

            ResultSetMetaData rsmd = rs.getMetaData();
            int numberOfColumns = rsmd.getColumnCount();

            while (rs.next()) {

                for (int i = 1; i <= numberOfColumns; i++) {
                    if (i > 1)
                        System.out.print(", ");
                    String columnValue = rs.getString(i);
                    System.out.print(columnValue);
                }
                System.out.println("");
            }

            st.close();
            con.close();

        } catch (Exception ex) {
            System.err.print("Exception: ");
            System.err.println(ex.getMessage());
        }
*/

        //Setting the jFrame
        JFrame frame = new JFrame("Traveler");
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);
        frame.setLocation(430, 100);

        //title
        JLabel title = new JLabel(" PRODUCTION TRAVELER");
        title.setFont(new Font("Calibri", Font.PLAIN, 18));
        title.setForeground(Color.BLUE);
        title.setAlignmentX(Component.CENTER_ALIGNMENT);
        //setting pannel
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS)); // added code
        frame.add(panel);
        panel.add(title);

        //getting the PO number from User
        // JTextField
        JTextField t = new JTextField( 16);
        JLabel l = new JLabel("PO #");
        //add button to the textfield pannel
        l.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(l);
        //content.add(t);
        t.setMaximumSize(t.getPreferredSize()); // added code
        t.setAlignmentX(Component.CENTER_ALIGNMENT);// added code
        panel.add(t);
        final String[] PoNum = new String[1];


        //Customer Scroll bar
        JLabel lbl = new JLabel("Select the Custumer:");
        lbl.setAlignmentX(Component.CENTER_ALIGNMENT);

        panel.add(lbl);
        //Array of all the customers
        String[] CUSTchoices = { " ","Composites One Lakeland FL", "Composites One Bristol RI", "Composites One Rockland ME",
                "Composites One South Houston TX", "Composites One Forth Worth TX", "Composites One Miami Gardens FL",
                "Composites One Katy TX", "Composites One Lenexa KS", "Composites One Rockhill SC", "Composites One Goshen IN",
                "Composites One Schaumburg IL", "Composites One Van Buren AR", "Indy Performance Brownsburg IN",
                "Composites Canada Division CA", "Composites One Madisonville TN", "Michael Wolf University of Texas",
                "S-2 Tiara Yachts Inc. Holland MI", "GE AMN Greenville SC", "Hytech Power Hollywood FL",
                "Midnight Express Boats Miami FL", "Eastern Burlap & Trading Co. Norfolk VA", "Johnson Fibreglass & Resin South Houston TX",
                "Mhogany Mays Landing NJ", "Thoroughbred Boat Company", "Ubique Technologies Clanton AL",
                "Avient Corporation-Polystrand Englewood CO", "Vixen Composites Elkhart IN", "Paxton Company Norfolk VA",
                "Regal Marine - Orlando FL", "Superior Coupens SC", "Sportsman Boats Summerville SC",
                "Asther Burciaga El Paso TX", "Circa Zapopan Jal MX", "CFD International Princeton TX", "North America Lakeland FL",
                "North American Composites Co Lakeland FL", "Composites One Valdosta Ga", "Composites One Fort Worth TX",
                "North America Nashville TN", "Daedalus Composites Edenton NC", "North America Lino Lakes MN",
                "EJ paiting & Fiberglass Brightin CO", "Indy Performance Brownsburg IN", "C/O IMEX LAREDO TX"};
        final JComboBox<String> cb = new JComboBox<String>(CUSTchoices);

        cb.setMaximumSize(cb.getPreferredSize()); // added code
        cb.setAlignmentX(Component.CENTER_ALIGNMENT);// added code

        panel.add(cb);

        JLabel jLabel = new JLabel();
        jLabel.setBounds(90, 100, 400, 100);
        final String[] selectedAddress = new String[1];


        JLabel lbl2 = new JLabel("Select the Part #:");
        lbl2.setAlignmentX(Component.CENTER_ALIGNMENT);

        panel.add(lbl2);
        //Array of all the customers
        String[] Materal = {    " ",     "CVM080-0102", "CVM080-0158", "CVM080-0167", "FGPET080G-3086", "FGPET080G-3163", "FGPET080G-3164", "FGPET080G-3169",
                                "FGPET080G-3167", "FGPET080G-3172", "FGPET080G-3219", "FGPET080G-3244", "FGPET080G-3245", "FGPET080G-3279", "FGPET080G-3280",
                                "FGPET080G-3307", "FGPET080G-3308", "FGPET080G-3309", "FGPET080G-3330", "FGPET080G-3339", "FGPET080G-3397", "FGPET080G-3408",
                                "FGPET080G-3421", "FGPET080G-3437", "FGPET080G-3812", "FGPET080G-3810", "FGPET080G-4573", "FGPET100G-3077", "FGPET100G-3077",
                                "FGPET100G-3077", "FGPET100G-3088", "FGPET100G-3091", "FGPET100G-3094", "FGPET100G-3096", "FGPET100G-3109", "FGPET100G-3110",
                                "FGPET100G-3110", "FGPET100G-3111", "FGPET100G-3114", "FGPET100G-3120", "FGPET100G-3121", "FGPET100G-3130", "FGPET100G-3131",
                                "FGPET100G-3137", "FGPET100G-3183", "FGPET100G-3184", "FGPET100G-3185", "FGPET100G-3190", "FGPET100G-3204", "FGPET100G-3219",
                                "FGPET100G-3221", "FGPET100G-3222", "FGPET100G-3224", "FGPET100G-3288", "FGPET100G-3316", "FGPET100G-3828", "FGPET100G-4509",
                                "FGPET100G-4510", "FGPET100G-3280", "FGPET100G-3285", "FGPET100G-3310", "FGPET100G-4502", "FGPET100G-3210", "FGPET115G-3082",
                                "FGPET115G-3083", "FGPET115G-3086", "FGPET115G-3088", "FGPET115G-3089", "FGPET115G-3091", "FGPET115G-3091", "FGPET115G-3092",
                                "FGPET115G-3093", "FGPET115G-3094", "FGPET115G-3102", "FGPET115G-3109", "FGPET115G-3114", "FGPET115G-3115", "FGPET115G-3116",
                                "FGPET115G-3116", "FGPET115G-3117", "FGPET115G-3116", "FGPET115G-3118", "FGPET115G-3119", "FGPET115G-3120", "FGPET115G-3122",
                                "FGPET115G-3124", "FGPET115G-3125", "FGPET115G-3126", "FGPET115G-3129", "FGPET115G-4537", "FGPET115G-3140", "FGPET115G-3187",
                                "FGPET115G-3187", "FGPET115G-3206", "FGPET115G-3224", "FGPET115G-3266", "FGPET115G-3294", "FGPET115G-3308", "FGPET115G-3310",
                                "FGPET115G-3322", "FGPET115G-4503", "FGPET115G-4504", "FGPET115G-4505", "FGPET115G-4506", "FGPET115G-4510", "FGPET115G-4538",
                                "FGPET135G-3039", "FGPET135G-3041", "FGPET135G-3079", "FGPET135G-3613", "FGPET135G-4515", "FGPET135G-4514", "FGPET200G-3033",
                                "FGPET200G-3043", "FGPET200G-3053", "FGPET200G-3577", "FGPET200G-3591", "FGPET300G-3007", "FGPET300G-3009", "FGPET300G-3012",
                                "FGPET300G-3013", "FGPET300G-3020", "FGPET300G-3020", "FGPET300G-3021", "FGPET300G-3021", "FGPET080G-4531", "FGPET080G-3280",
                                "FGPET135G-4510", "FGPET080G-3380", "FGPET135G-3616", "FGPET300G-3022", "FGPET300G-3024", "FGPET300G-3036", "FGPET300G-3040",
                                "FGPET300G-3046", "FGPET300G-3049", "FGPET300G-4517", "FGPET300G-4518", "FGPET300G-4519", "FGPET300G-4520", "FGPET115G-3097",
                                "FGPET115G-3098", "FGPET115G-3127", "FGPET115G-3294", "FGPET100G-3119", "FGPET115G-3182", "FGPET100G-3209", "FGPET080G-3211",
                                "FGPET115G-3117", "FGPET115G-3123", "FGPET080G-3244", "FGPET080G-4503", "FGPET100G-3277", "FGPET100G-3201", "FGPET100G-4502",
                                "FGPET115G-3087", "FGPET100G-3212", "FGPET115G-3254", "FGPET115G-3255", "FGPET300G-3039", "FGPET135G-3065", "FGPET135G-3073",
                                "FGPET115G-3090", "FGPET100G-4502", "FGPET115G-3100", "FGPET115G-3128", "FGPET100G-3211", "FGPET115G-3181", "FGPET080G-3171",
                                "FGPET080G-3169", "FGPET080G-4503", "FGPET100G-3201", "FGPET115G-3134", "FGPET115G-3140", "FGPET80G-3171", "FGPET115G-3222",
                                "FGPET100G-3222", "FGPET300G-4511", "FGPET080G-4544", "FGKERDYN300-S001", "FGPET115G-3310", "FGPET115G-3222", "FGPET100G-3316",
                                "FGPET300G-3039", "FGPET115G-3239", "FGPET300G-4513", "FGPET080G-3380", "FGPET080G-4531", "FGPET080G-3280", "FGPET135G-4510",
                                "FGPET115G-3239", "FGPET300G-3039", "FGPET100G-3285",
        };
        final JComboBox<String> m = new JComboBox<String>(Materal);
        String[] ChosenMaterial= new String[1];

        m.setMaximumSize(cb.getPreferredSize()); // added code
        m.setAlignmentX(Component.CENTER_ALIGNMENT);// added code

        panel.add(m);

        JLabel jLabel2 = new JLabel();
        jLabel.setBounds(90, 100, 400, 100);


        //getting the Quantity number from User
        // JTextField
        JTextField Q = new JTextField( 16);
        JLabel ql = new JLabel("Quantity #");
        //add button to the textfield pannel
        ql.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(ql);
        //content.add(t);
        Q.setMaximumSize(t.getPreferredSize()); // added code
        Q.setAlignmentX(Component.CENTER_ALIGNMENT);// added code
        panel.add(Q);
        final String[] QuantityNum = new String[1];




        //due date
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        LocalDateTime DueDate = LocalDateTime.now();
        System.out.println(dtf.format(DueDate));

        //order Number

        // JTextField
        JTextField O = new JTextField( 16);
        JLabel ol = new JLabel("Order #");
        //add button to the textfield pannel
        ol.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(ol);
        //content.add(t);
        O.setMaximumSize(t.getPreferredSize()); // added code
        O.setAlignmentX(Component.CENTER_ALIGNMENT);// added code
        panel.add(O);
        final String[] OrderNum = new String[1];

        // Sheets per box
        JTextField sxb = new JTextField( 16);
        JLabel sxbl = new JLabel("Sheets per Box");
        //add button to the textfield pannel
        sxbl.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(sxbl);
        //content.add(t);
        sxb.setMaximumSize(t.getPreferredSize()); // added code
        sxb.setAlignmentX(Component.CENTER_ALIGNMENT);// added code
        panel.add(sxb);
        final String[] SheetsPerBox = new String[1];

        //first box
        // Sheets per box
        JTextField firstb = new JTextField( 16);
        JLabel firstbl = new JLabel("First Box:");
        //add button to the textfield pannel
       firstbl.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(firstbl);
        //content.add(t);
        firstb.setMaximumSize(t.getPreferredSize()); // added code
        firstb.setAlignmentX(Component.CENTER_ALIGNMENT);// added code
        panel.add(firstb);
        final String[] FirstBox = new String[1];
        final String[] lastBox = new String[1];

        //total boxes
        final int[] totalBoxes = new int[1];

        JButton btn = new JButton("OK");
        btn.setAlignmentX(Component.CENTER_ALIGNMENT); // added code
        panel.add(btn);
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               // cb.setVisible(false);
               // t.setVisible(false);
                selectedAddress[0] =cb.getItemAt(cb.getSelectedIndex());
                jLabel.setText(selectedAddress[0]);
                PoNum[0] = t.getText();
                QuantityNum[0]= Q.getText();
                ChosenMaterial[0]= m.getItemAt(m.getSelectedIndex());
                OrderNum[0]= O.getText();
                SheetsPerBox[0]= sxb.getText();
                totalBoxes[0] = Integer.parseInt(QuantityNum[0])/Integer.parseInt(SheetsPerBox[0]);
                FirstBox[0]= firstb.getText();
                lastBox[0] = String.valueOf(Integer.parseInt(FirstBox[0]) + (totalBoxes[0]-1));


                JOptionPane.showMessageDialog(null,
                        "MAKE SURE ITS ALL CORRECT"+
                                "\nCUSTOMER: "+ selectedAddress[0]+
                                "\nPart #: "+ ChosenMaterial[0]+
                                "\nPO #: " +PoNum[0]+
                                "\nQuantity: "+ QuantityNum[0]+
                                "\nDue Date: "+dtf.format(DueDate)+
                                "\nOrder #: "+OrderNum[0]+
                                "\nSheets per Box: "+ SheetsPerBox[0]+
                                "\nBoxes : " + totalBoxes[0]+
                                "\nFirst Box: "+ FirstBox[0]+
                                "\nLast Box: "+ lastBox[0]+
                                "\n******Create PDF********" +
                                "\n****Press PDF BUTTON****"
                                 ) ;

                //System.out.println(selectedAddress[0]);
                //add to the file
                //CREATE txt DOC
                String tDoc = PoNum[0]+ "Traveler.docx";
            }
        });
        JButton PDFbtn = new JButton("PDF");
        PDFbtn.setAlignmentX(Component.CENTER_ALIGNMENT); // added code
        panel.add(PDFbtn);
        PDFbtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // cb.setVisible(false);
                // t.setVisible(false);
                selectedAddress[0] =cb.getItemAt(cb.getSelectedIndex());
                jLabel.setText(selectedAddress[0]);
                PoNum[0] = t.getText();
                QuantityNum[0]= Q.getText();
                ChosenMaterial[0]= m.getItemAt(m.getSelectedIndex());
                OrderNum[0]= O.getText();
                SheetsPerBox[0]= sxb.getText();
                totalBoxes[0] = Integer.parseInt(QuantityNum[0])/Integer.parseInt(SheetsPerBox[0]);
                FirstBox[0]= firstb.getText();
                lastBox[0] = String.valueOf(Integer.parseInt(FirstBox[0]) + (totalBoxes[0]-1));


                JOptionPane.showMessageDialog(null,
                        "Creating PDF ......"

                ) ;

                //System.out.println(selectedAddress[0]);
                //add to the file
                //CREATE txt DOC
                String tDoc = PoNum[0]+ "Traveler.docx";
            }
        });

        frame.setVisible(true); // added code

        System.out.println(selectedAddress[0]);
        System.out.println(PoNum[0]);
    }




}
