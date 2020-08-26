package com.zzp.provider.entity;

import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author zzp
 * @since 2020-06-23
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class TQuoteSupplierTransport implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "ID", type = IdType.AUTO)
    private Integer id;

    /**
     * 服务商公司UID
     */
    @TableField("SERVICE_PROVIDER_UID")
    private String serviceProviderUid;

    /**
     * 服务商公司
     */
    @TableField("SERVICE_PROVIDER")
    private String serviceProvider;

    /**
     * 报价人
     */
    @TableField("QUOTER")
    private String quoter;

    /**
     * 询价公司UID
     */
    @TableField("INQUIRER_COMPANY_UID")
    private String inquirerCompanyUid;

    /**
     * 询价人
     */
    @TableField("INQUIRER")
    private String inquirer;

    /**
     * 出发地
     */
    @TableField("DEPARTURE_PLACE")
    private String departurePlace;

    /**
     * 出发地省级ID
     */
    @TableField("DEPARTURE_PROVINCE_ID")
    private Integer departureProvinceId;

    /**
     * 出发地市级ID
     */
    @TableField("DEPARTURE_CITY_ID")
    private Integer departureCityId;

    /**
     * 出发地区级ID
     */
    @TableField("DEPARTURE_DISTRICT_ID")
    private Integer departureDistrictId;

    /**
     * 出发地地段ID
     */
    @TableField("DEPARTURE_STREET_ID")
    private Integer departureStreetId;

    /**
     * 目的地
     */
    @TableField("DESTINATION_PLACE")
    private String destinationPlace;

    /**
     * 目的地省级ID
     */
    @TableField("DESTINATION_PROVINCE_ID")
    private Integer destinationProvinceId;

    /**
     * 目的地市级ID
     */
    @TableField("DESTINATION_CITY_ID")
    private Integer destinationCityId;

    /**
     * 目的地区级ID
     */
    @TableField("DESTINATION_DISTRICT_ID")
    private Integer destinationDistrictId;

    /**
     * 目的地地段ID
     */
    @TableField("DESTINATION_STREET_ID")
    private Integer destinationStreetId;

    /**
     * 中转地
     */
    @TableField("TRANSFER_PLACE")
    private String transferPlace;

    /**
     * 报价模式: 1车次/柜, 2货物重量
     */
    @TableField("QUOTE_MODEL")
    private Integer quoteModel;

    /**
     * 货物类型: 1普货, 2危险品, 3温控货物
     */
    @TableField("CARGO_TYPE")
    private Integer cargoType;

    /**
     * 最低消费
     */
    @TableField("MIN_COST")
    private BigDecimal minCost;

    /**
     * 货物单位
     */
    @TableField("VALUATION_UNIT")
    private String valuationUnit;

    /**
     * 柜型
     */
    @TableField("TRUCK_TYPE")
    private String truckType;

    /**
     * 单价
     */
    @TableField("PRICE")
    private BigDecimal price;

    /**
     * 生效日期
     */
    @TableField("ALIVE_BEGIN_TIME")
    private LocalDateTime aliveBeginTime;

    /**
     * 失效日期
     */
    @TableField("ALIVE_END_TIME")
    private LocalDateTime aliveEndTime;

    /**
     * 是否失效, 0失效, 1生效
     */
    @TableField("ALIVE_FLAG")
    private Integer aliveFlag;

    /**
     * 状态: 0未审核、1已审核、2已作废
     */
    @TableField("STATUS")
    private Integer status;

    /**
     * 备注
     */
    @TableField("REMARK")
    private String remark;

    /**
     * 创建者
     */
    @TableField("CREATOR")
    private String creator;

    /**
     * 创建时间
     */
    @TableField("CREATE_AT")
    private LocalDateTime createAt;

    /**
     * 是否转关:0否, 1是
     */
    @TableField("TRANSIT")
    private Integer transit;

    /**
     * 是否备案:0否, 1是
     */
    @TableField("REPORT")
    private Integer report;

    /**
     * 车型
     */
    @TableField("CAR_TYPE")
    private Integer carType;

    /**
     * 币种
     */
    @TableField("CURRENCY_UNIT")
    private String currencyUnit;

    /**
     * 关联客户UID
     */
    @TableField("CUSTOMER_COMPANY_UID")
    private String customerCompanyUid;

    /**
     * 一阶数量
     */
    @TableField("FIRST_VALUATION_COUNT")
    private BigDecimal firstValuationCount;

    /**
     * 二阶数量
     */
    @TableField("SECOND_VALUATION_COUNT")
    private BigDecimal secondValuationCount;

    /**
     * 三阶数量
     */
    @TableField("THIRD_VALUATION_COUNT")
    private BigDecimal thirdValuationCount;

    /**
     * 一阶价格
     */
    @TableField("FIRST_PRICE")
    private BigDecimal firstPrice;

    /**
     * 二阶价格
     */
    @TableField("SECOND_PRICE")
    private BigDecimal secondPrice;

    /**
     * 三阶价格
     */
    @TableField("THIRD_PRICE")
    private BigDecimal thirdPrice;

    /**
     * 还柜加收
     */
    @TableField("CONTAINER_AMOUNT")
    private BigDecimal containerAmount;

    /**
     * 关联客户name
     */
    @TableField("CUSTOMER_COMPANY_NAME")
    private String customerCompanyName;

    @TableField("MD5_VALUE")
    private String md5Value;

    /**
     * 原id
     */
    @TableField("OLD_ID")
    private Integer oldId;

    /**
     * 四阶报价
     */
    @TableField("FOURTH_PRICE")
    private BigDecimal fourthPrice;

    /**
     * 四阶数量
     */
    @TableField("FOURTH_VALUATION_COUNT")
    private BigDecimal fourthValuationCount;

    /**
     * 五阶报价
     */
    @TableField("FIFTH_PRICE")
    private BigDecimal fifthPrice;

    /**
     * 五阶数量
     */
    @TableField("FIFTH_VALUATION_COUNT")
    private BigDecimal fifthValuationCount;

    /**
     * 六阶报价
     */
    @TableField("SIXTH_PRICE")
    private BigDecimal sixthPrice;

    /**
     * 六阶数量
     */
    @TableField("SIXTH_VALUATION_COUNT")
    private BigDecimal sixthValuationCount;


}
