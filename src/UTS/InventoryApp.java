package UTS;

import java.sql.Connection;
import java.sql.ResultSet;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.text.NumberFormat;
import java.util.Locale;

public class InventoryApp extends javax.swing.JFrame {

    DefaultTableModel tabmode;
    DefaultListModel<String> model = new DefaultListModel<>();

    public InventoryApp() {
        setTitle("Aplikasi Inventaris Barang");
        initComponents();
        Object[] row = {"NO.", "KODE", "NAMA", "JUMLAH", "KEADAAN BARANG", "HARGA", "KETERANGAN"};
        tabmode = new DefaultTableModel(null, row);
        tabledata.setModel(tabmode);
        listRiwayat.setModel(model);
        load_table();
    }

    private void load_table() {
        try {
            tabmode.setRowCount(0); 
            int no = 1;

            String sql = "SELECT * FROM tabel";
            java.sql.Connection conn = (Connection) config.getInventory();
            java.sql.Statement stm = conn.createStatement();
            java.sql.ResultSet res = stm.executeQuery(sql);

            NumberFormat formatRupiah = NumberFormat.getCurrencyInstance(new Locale("id", "ID"));
            while (res.next()) {
                double harga = res.getDouble(5);
                String hargaFormatted = formatRupiah.format(harga);
                tabmode.addRow(new Object[]{
                    no++,
                    res.getString(1),
                    res.getString(2),
                    res.getString(3),
                    res.getString(4),
                    hargaFormatted,
                    res.getString(6)
                });
            }

            tabledata.setModel(tabmode);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void bersihkan() {
        txtKodeBarang.setText(null);
        txtNamaBarang.setText(null);
        txtJumlahBarang.setText(null);
        txtHarga.setText(null);
        txtKeterangan.setText(null);
        baik.setSelected(false);
        kurangbaik.setSelected(false);
        rusak.setSelected(false);
        txtKodeBarang.requestFocus();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        labelStatus = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtKodeBarang = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtNamaBarang = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtJumlahBarang = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        baik = new javax.swing.JRadioButton();
        kurangbaik = new javax.swing.JRadioButton();
        rusak = new javax.swing.JRadioButton();
        buttonSimpan = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        txtHarga = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtKeterangan = new javax.swing.JTextArea();
        btnHapus = new javax.swing.JButton();
        buttonUpdate = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        listRiwayat = new javax.swing.JList<>();
        jLabel10 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tabledata = new javax.swing.JTable();
        jLabel9 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        txtCari = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        btnPDF = new javax.swing.JButton();
        btnKeluar = new javax.swing.JButton();
        buttonRefresh = new javax.swing.JButton();

        labelStatus.setText("jLabel11");

        jButton1.setText("jButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 255)));
        jPanel1.setForeground(new java.awt.Color(102, 102, 255));

        jLabel1.setBackground(new java.awt.Color(102, 102, 255));
        jLabel1.setFont(new java.awt.Font("Nirmala UI", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(102, 102, 255));
        jLabel1.setText("FORM");

        jLabel2.setText("KODE BARANG");

        jLabel3.setText("NAMA BARANG");

        jLabel4.setText("JUMLAH BARANG");

        txtJumlahBarang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtJumlahBarangActionPerformed(evt);
            }
        });

        jLabel5.setText("KONDISI BARANG");

        buttonGroup1.add(baik);
        baik.setText("BAIK");

        buttonGroup1.add(kurangbaik);
        kurangbaik.setText("KURANG BAIK");

        buttonGroup1.add(rusak);
        rusak.setText("RUSAK");

        buttonSimpan.setBackground(new java.awt.Color(59, 89, 182));
        buttonSimpan.setFont(new java.awt.Font("Nirmala UI", 0, 14)); // NOI18N
        buttonSimpan.setForeground(new java.awt.Color(255, 255, 255));
        buttonSimpan.setText("SAVE");
        buttonSimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonSimpanActionPerformed(evt);
            }
        });

        jLabel6.setText("HARGA BARANG");

        txtHarga.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtHargaActionPerformed(evt);
            }
        });

        jLabel8.setText("KETERANGAN");

        txtKeterangan.setColumns(20);
        txtKeterangan.setRows(5);
        jScrollPane2.setViewportView(txtKeterangan);

        btnHapus.setBackground(new java.awt.Color(181, 59, 59));
        btnHapus.setFont(new java.awt.Font("Nirmala UI", 0, 14)); // NOI18N
        btnHapus.setForeground(new java.awt.Color(255, 255, 255));
        btnHapus.setText("DELETE");
        btnHapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHapusActionPerformed(evt);
            }
        });

        buttonUpdate.setBackground(new java.awt.Color(59, 89, 182));
        buttonUpdate.setFont(new java.awt.Font("Nirmala UI", 0, 14)); // NOI18N
        buttonUpdate.setForeground(new java.awt.Color(255, 255, 255));
        buttonUpdate.setText("EDIT");
        buttonUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonUpdateActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(13, 13, 13)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(baik, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(kurangbaik, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(rusak, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                    .addGap(13, 13, 13)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel2)
                                        .addComponent(txtKodeBarang, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel3)
                                    .addComponent(txtNamaBarang, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
                                    .addComponent(txtJumlahBarang)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(16, 16, 16)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel6)
                                    .addComponent(txtHarga, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                            .addComponent(buttonSimpan)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(buttonUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(btnHapus, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(149, 149, 149)
                        .addComponent(jLabel1)))
                .addGap(37, 37, 37))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(4, 4, 4)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtKodeBarang, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3)
                .addGap(4, 4, 4)
                .addComponent(txtNamaBarang, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtJumlahBarang, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(kurangbaik)
                    .addComponent(rusak)
                    .addComponent(baik))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtHarga, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnHapus)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(buttonSimpan)
                        .addComponent(buttonUpdate)))
                .addContainerGap(8, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 255)));
        jPanel2.setForeground(new java.awt.Color(102, 102, 255));

        listRiwayat.setFont(new java.awt.Font("Nirmala UI", 0, 14)); // NOI18N
        jScrollPane1.setViewportView(listRiwayat);

        jLabel10.setBackground(new java.awt.Color(102, 102, 255));
        jLabel10.setFont(new java.awt.Font("Nirmala UI", 1, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(102, 102, 255));
        jLabel10.setText("RIWAYAT");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel10)
                .addGap(252, 252, 252))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 175, Short.MAX_VALUE)
                .addContainerGap())
        );

        jLabel7.setBackground(new java.awt.Color(102, 102, 255));
        jLabel7.setFont(new java.awt.Font("Nirmala UI", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(102, 102, 255));
        jLabel7.setText("INVENTARIS BARANG");

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 255)));

        tabledata.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5", "Title 6"
            }
        ));
        tabledata.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabledataMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tabledata);

        jLabel9.setBackground(new java.awt.Color(102, 102, 255));
        jLabel9.setFont(new java.awt.Font("Nirmala UI", 1, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(102, 102, 255));
        jLabel9.setText("DAFTAR BARANG");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 578, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(214, 214, 214)
                        .addComponent(jLabel9)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 255)));

        txtCari.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtCariKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCariKeyTyped(evt);
            }
        });

        jPanel3.setBackground(new java.awt.Color(102, 102, 255));

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UTS/icon/search.png"))); // NOI18N

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtCari)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtCari))
                .addContainerGap())
        );

        btnPDF.setBackground(new java.awt.Color(255, 153, 102));
        btnPDF.setFont(new java.awt.Font("Nirmala UI", 0, 14)); // NOI18N
        btnPDF.setForeground(new java.awt.Color(255, 255, 255));
        btnPDF.setText("Save PDF");
        btnPDF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPDFActionPerformed(evt);
            }
        });

        btnKeluar.setBackground(new java.awt.Color(153, 153, 153));
        btnKeluar.setFont(new java.awt.Font("Nirmala UI", 0, 14)); // NOI18N
        btnKeluar.setForeground(new java.awt.Color(255, 255, 255));
        btnKeluar.setText("EXIT");
        btnKeluar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKeluarActionPerformed(evt);
            }
        });

        buttonRefresh.setBackground(new java.awt.Color(153, 153, 153));
        buttonRefresh.setFont(new java.awt.Font("Nirmala UI", 0, 14)); // NOI18N
        buttonRefresh.setForeground(new java.awt.Color(255, 255, 255));
        buttonRefresh.setText("CLEAR");
        buttonRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonRefreshActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnPDF, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(36, 36, 36))
                            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(buttonRefresh)
                        .addGap(18, 18, 18)
                        .addComponent(btnKeluar)
                        .addGap(43, 43, 43)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 332, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(btnPDF))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(buttonRefresh)
                            .addComponent(btnKeluar)))
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(10, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtJumlahBarangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtJumlahBarangActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtJumlahBarangActionPerformed

    private void btnHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHapusActionPerformed
        try {
            String sql = "DELETE FROM tabel WHERE kode_barang= '" + txtKodeBarang.getText() + "'";
            java.sql.Connection conn = (Connection) config.getInventory();
            java.sql.PreparedStatement pst = conn.prepareStatement(sql);
            pst.execute();
            JOptionPane.showMessageDialog(this, "Data Berhasil Dihapus");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
        load_table();
        bersihkan();
    }//GEN-LAST:event_btnHapusActionPerformed

    private void txtHargaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtHargaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtHargaActionPerformed

    private void btnKeluarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKeluarActionPerformed
        // TODO add your handling code here:
        int confirm = JOptionPane.showConfirmDialog(this, "Anda yakin ingin keluar?", "Konfirmasi", JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.YES_OPTION) {
            dispose();
        }
    }//GEN-LAST:event_btnKeluarActionPerformed

    private void buttonRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonRefreshActionPerformed
        // TODO add your handling code here:
        bersihkan();
    }//GEN-LAST:event_buttonRefreshActionPerformed

    private void buttonSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonSimpanActionPerformed
         // Simpan data barang ke dalam database
        try {
            // Validasi input
            String keadaanBarang = "";
            if (baik.isSelected()) {
                keadaanBarang = "Baik";
            } else if (kurangbaik.isSelected()) {
                keadaanBarang = "Kurang Baik";
            } else if (rusak.isSelected()) {
                keadaanBarang = "Rusak";
            }

            // Validasi apakah semua kolom terisi
            if (txtKodeBarang.getText().isEmpty() || txtNamaBarang.getText().isEmpty()
                    || txtJumlahBarang.getText().isEmpty() || txtHarga.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Semua kolom harus diisi!");
                return;
            }

            // Konversi harga menjadi angka valid
            double harga;
            try {
                harga = Double.parseDouble(txtHarga.getText().replace(",", "").replace(".", ""));
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Harga harus berupa angka yang valid!");
                return;
            }

            // Format harga ke dalam rupiah
            NumberFormat formatRupiah = NumberFormat.getCurrencyInstance(new Locale("id", "ID"));
            String hargaFormatted = formatRupiah.format(harga);

            // Query untuk menyimpan data
            String sql = "INSERT INTO tabel (kode_barang, nama_barang, jumlah_barang, keadaan, harga_barang, keterangan) VALUES ('"
                    + txtKodeBarang.getText() + "','"
                    + txtNamaBarang.getText() + "',"
                    + txtJumlahBarang.getText() + ",'"
                    + keadaanBarang + "',"
                    + harga + ",'"
                    + txtKeterangan.getText() + "')";

            java.sql.Connection conn = (java.sql.Connection) config.getInventory();
            java.sql.PreparedStatement pst = conn.prepareStatement(sql);
            pst.execute();

            JOptionPane.showMessageDialog(null, "Data Berhasil Disimpan");

            // Menambahkan ke riwayat
            DefaultListModel<String> model = (DefaultListModel<String>) listRiwayat.getModel();
            model.addElement("Kode Barang: " + txtKodeBarang.getText().trim() + " - "
                    + "Nama Barang: " + txtNamaBarang.getText().trim() + " - "
                    + "Jumlah Barang: " + txtJumlahBarang.getText().trim() + " - "
                    + "Keadaan: " + keadaanBarang.trim() + " - "
                    + "Harga: " + hargaFormatted + " - "
                    + "Keterangan: " + txtKeterangan.getText().trim()
            );

            // Refresh tabel dan form input
            load_table();
            bersihkan();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Terjadi kesalahan: " + e.getMessage());
        }
    }//GEN-LAST:event_buttonSimpanActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        // TODO add your handling code here:
    }//GEN-LAST:event_formWindowOpened

    private void buttonUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonUpdateActionPerformed
        try {
            String keadaanBarang = "";
            if (baik.isSelected()) {
                keadaanBarang = "Baik";
            } else if (kurangbaik.isSelected()) {
                keadaanBarang = "Kurang Baik";
            } else if (rusak.isSelected()) {
                keadaanBarang = "Rusak";
            }
            if (txtKodeBarang.getText().isEmpty() || txtNamaBarang.getText().isEmpty()
                    || txtJumlahBarang.getText().isEmpty() || txtHarga.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Semua kolom harus diisi!");
                return;
            }
            double harga;
            try {
                harga = Double.parseDouble(txtHarga.getText().replace(",", "").replace(".", ""));
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Harga harus berupa angka yang valid!");
                return;
            }
            NumberFormat formatRupiah = NumberFormat.getCurrencyInstance(new Locale("id", "ID"));
            String hargaFormatted = formatRupiah.format(harga);
            String sql = "UPDATE tabel SET "
                    + "nama_barang = ?, "
                    + "jumlah_barang = ?, "
                    + "keadaan = ?, "
                    + "harga_barang = ?, "
                    + "keterangan = ? "
                    + "WHERE kode_barang = ?";

            java.sql.Connection conn = (java.sql.Connection) config.getInventory();
            java.sql.PreparedStatement pst = conn.prepareStatement(sql);

            pst.setString(1, txtNamaBarang.getText());
            pst.setInt(2, Integer.parseInt(txtJumlahBarang.getText()));
            pst.setString(3, keadaanBarang);
            pst.setDouble(4, harga);
            pst.setString(5, txtKeterangan.getText());
            pst.setString(6, txtKodeBarang.getText());

            int rowsUpdated = pst.executeUpdate();
            if (rowsUpdated > 0) {
                JOptionPane.showMessageDialog(null, "Data Berhasil Diupdate");
                load_table();
                bersihkan();
            } else {
                JOptionPane.showMessageDialog(null, "Kode Barang Tidak Ditemukan!");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Terjadi kesalahan: " + e.getMessage());
        }
    }//GEN-LAST:event_buttonUpdateActionPerformed

    private void tabledataMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabledataMouseClicked

        int baris = tabledata.rowAtPoint(evt.getPoint());
        String kodeBarang = tabledata.getValueAt(baris, 1).toString();
        String namaBarang = tabledata.getValueAt(baris, 2).toString();
        String jumlahBarang = tabledata.getValueAt(baris, 3).toString();
        String keadaan = tabledata.getValueAt(baris, 4).toString();
        String hargaBarang = tabledata.getValueAt(baris, 5).toString();
        String keterangan = tabledata.getValueAt(baris, 6).toString();
        txtKodeBarang.setText(kodeBarang);
        txtNamaBarang.setText(namaBarang);
        txtJumlahBarang.setText(jumlahBarang);
        txtHarga.setText(hargaBarang);
        txtKeterangan.setText(keterangan);
        if (keadaan.equalsIgnoreCase("Baik")) {
            baik.setSelected(true);
        } else if (keadaan.equalsIgnoreCase("Kurang Baik")) {
            kurangbaik.setSelected(true);
        } else if (keadaan.equalsIgnoreCase("Rusak")) {
            rusak.setSelected(true);
        }
        txtNamaBarang.requestFocus();
    }//GEN-LAST:event_tabledataMouseClicked

    private void txtCariKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCariKeyTyped

    }//GEN-LAST:event_txtCariKeyTyped

    private void txtCariKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCariKeyReleased
        String keyword = txtCari.getText().trim();
        if (keyword.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Kolom pencarian tidak boleh kosong!");
            txtCari.requestFocus();
            return;
        }
        try {
             // Membuka database
            java.sql.Connection conn = (java.sql.Connection) config.getInventory();
             // Query pencarian menggunakan LIKE
            String sql = "SELECT * FROM tabel WHERE "
                    + "kode_barang LIKE ? OR "
                    + "nama_barang LIKE ? OR "
                    + "jumlah_barang LIKE ? OR "
                    + "keadaan LIKE ? OR "
                    + "harga_barang LIKE ? OR "
                    + "keterangan LIKE ?";
            java.sql.PreparedStatement stat = conn.prepareStatement(sql);
            for (int i = 1; i <= 6; i++) {
                stat.setString(i, "%" + keyword + "%");
            }
            
            ResultSet set = stat.executeQuery();
            tabmode.setRowCount(0);// Reset tabel

            int no = 1;
            boolean dataDitemukan = false; // Cek data apakah ditemukan
            while (set.next()) {
                dataDitemukan = true; // Jika data ditemukan

                tabmode.addRow(new Object[]{
                    no++,
                    set.getString("kode_barang"),
                    set.getString("nama_barang"),
                    set.getString("jumlah_barang"),
                    set.getString("keadaan"),
                    set.getString("harga_barang"),
                    set.getString("keterangan")
                });
            }

            if (!dataDitemukan) {
                JOptionPane.showMessageDialog(null, "Data tidak ditemukan untuk keyword: " + keyword);
            }

            bersihkan();
            txtCari.requestFocus();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Terjadi kesalahan saat mencari data: " + e.getMessage());
            e.printStackTrace();
        }
    }//GEN-LAST:event_txtCariKeyReleased

    private void btnPDFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPDFActionPerformed
        exportToPDF();

    }//GEN-LAST:event_btnPDFActionPerformed

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;

                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(InventoryApp.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InventoryApp.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InventoryApp.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InventoryApp.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new InventoryApp().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JRadioButton baik;
    public static javax.swing.JButton btnHapus;
    public static javax.swing.JButton btnKeluar;
    public static javax.swing.JButton btnPDF;
    private javax.swing.ButtonGroup buttonGroup1;
    public static javax.swing.JButton buttonRefresh;
    public static javax.swing.JButton buttonSimpan;
    public static javax.swing.JButton buttonUpdate;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    public static javax.swing.JRadioButton kurangbaik;
    public static javax.swing.JLabel labelStatus;
    public static javax.swing.JList<String> listRiwayat;
    public static javax.swing.JRadioButton rusak;
    public static javax.swing.JTable tabledata;
    private javax.swing.JTextField txtCari;
    public static javax.swing.JTextField txtHarga;
    public static javax.swing.JTextField txtJumlahBarang;
    public static javax.swing.JTextArea txtKeterangan;
    public static javax.swing.JTextField txtKodeBarang;
    public static javax.swing.JTextField txtNamaBarang;
    // End of variables declaration//GEN-END:variables

    private void exportToPDF() {
        String filePath = "D:\\SEMESTER 3\\Project_PBO\\CETAK_UTS\\data_inventory.pdf";
        com.itextpdf.text.Document document = new com.itextpdf.text.Document();

        try {
            File folder = new File("D:\\SEMESTER 3\\Project_PBO\\CETAK_UTS");
            if (!folder.exists()) {
                folder.mkdirs();
            }
            PdfWriter.getInstance(document, new FileOutputStream(filePath));
            document.open();
            Font titleFont = new Font(Font.FontFamily.HELVETICA, 16, Font.BOLD);
            Paragraph title = new Paragraph("Data Inventory", titleFont);
            title.setAlignment(Element.ALIGN_CENTER);
            document.add(title);
            document.add(new Paragraph("\n"));
            PdfPTable pdfTable = new PdfPTable(tabledata.getColumnCount());
            pdfTable.setWidthPercentage(100);
            for (int i = 0; i < tabledata.getColumnCount(); i++) {
                PdfPCell cell = new PdfPCell(new Phrase(tabledata.getColumnName(i)));
                cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                pdfTable.addCell(cell);
            }
            for (int row = 0; row < tabledata.getRowCount(); row++) {
                for (int col = 0; col < tabledata.getColumnCount(); col++) {
                    pdfTable.addCell(tabledata.getValueAt(row, col).toString());
                }
            }
            document.add(pdfTable);
            JOptionPane.showMessageDialog(null, "PDF berhasil dibuat di: " + filePath);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Terjadi kesalahan: " + e.getMessage());
        } finally {
            document.close();
        }
    }
}
