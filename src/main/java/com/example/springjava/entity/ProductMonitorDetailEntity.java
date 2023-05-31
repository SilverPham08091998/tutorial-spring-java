package com.example.springjava.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity(name = "PRODUCT_MONITOR_DETAIL")
@Table(name = "PRODUCT_MONITOR_DETAIL")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductMonitorDetailEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", updatable = false, nullable = false)
    private Long id;

    // tên sản phầm : Màn hình Samsung LU28R550UQEXXV 28 inch
    @Column(name = "name")
    private String name;
    // tên sản phầm : Màn hình Samsung LU28R550UQEXXV 28 inch
    @Column(name = "title")
    private String title;
    // Nội dung
    @Column(name = "content")
    private String content;
    // màu
    @Column(name = "color")
    private String color;

    // độ phân giải : 5120x1280 pixel
    @Column(name = "display_resolution")
    private String displayResolution;

    // kích thước : 14 inch
    @Column(name = "display_size")
    private String displaySize;

    //kiểu hiển thị : cong , phẳng
    @Column(name = "display_type")
    private String displayType;

    // tần số quét
    @Column(name = "frequency")
    private String frequency;

    //Kích thước : dài rộng dày;
    @Column(name = "dimensions")
    private String dimensions;

    // Nhà phát hành
    @Column(name = "manufacturer")
    private String manufacturer;

    // khung : kim loại
    @Column(name = "material")
    private String material;

    // tầm nền màn hình : IPS
    @Column(name = "panels")
    private String panels;

    // âm thanh 3 microphones, 4 Loa
    @Column(name = "sound")
    private String sound;

    // Mô tả sản phẩm
    @Column(name = "description")
    private String description;

    // số lượng port : HDMI, typeC
    @Column(name = "port_connect")
    private String portConnect;

    // tay arm: 75x75
    @Column(name = "monitor_arm")
    private String monitorArm;

    //tỉ lệ chia màn hình:16:9
    @Column(name = "aspect_ratio")
    private String aspectRatio;

    // độ phản hổi: 4ms
    @Column(name = "responsiveness")
    private String responsiveness;

    // góc nhìn: 178°(ngang) x 178° (dọc)
    @Column(name = "view")
    private String view;
    // Số lượng màu : 1 tỉ màu
    @Column(name = "quantity_color")
    private String quantityColor;
    // Công nghệ đồng bộ : Công nghệ đồng bộ: FreeSync, HDR10
    @Column(name = "tech_sync")
    private String techSync;

    // độ sáng 300 cd/m2
    @Column(name = "brightness")
    private String brightness;

    // độ phủ màu 0.9 Color Gamut (DCI Coverage)
    @Column(name = "color_coverage")
    private String colorCoverage;
    // trọng lượng
    @Column(name = "weight")
    private String weight;


    @Column(name = "urlImage")
    private String urlImage;

    @OneToOne
    @JoinColumn(name = "PRODUCT_ID")
    private ProductEntity productEntity;
}
