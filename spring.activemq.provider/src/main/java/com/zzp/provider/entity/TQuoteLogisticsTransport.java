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
public class TQuoteLogisticsTransport implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "ID", type = IdType.AUTO)
    private Integer id;

    /**
     * 委托方公司UID
     */
    @TableField("ENTRUSTING_UID")
    private String entrustingUid;

    /**
     * 委托方公司
     */
    @TableField("ENTRUSTING_UNIT")
    private String entrustingUnit;

    /**
     * 报价公司CODE
     */
    @TableField("QUOTER_COMPANY_CODE")
    private String quoterCompanyCode;

    /**
     * 报价人
     */
    @TableField("QUOTER")
    private String quoter;

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
     * 柜型
     */
    @TableField("TRUCK_TYPE")
    private String truckType;

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
     * 一阶计价数量
     */
    @TableField("FIRST_VALUATION_COUNT")
    private BigDecimal firstValuationCount;

    /**
     * 二阶计价数量
     */
    @TableField("SECOND_VALUATION_COUNT")
    private BigDecimal secondValuationCount;

    /**
     * 三阶计价数量
     */
    @TableField("THIRD_VALUATION_COUNT")
    private BigDecimal thirdValuationCount;

    /**
     * 一阶单价
     */
    @TableField("FIRST_PRICE")
    private BigDecimal firstPrice;

    /**
     * 二阶单价
     */
    @TableField("SECOND_PRICE")
    private BigDecimal secondPrice;

    /**
     * 三阶单价
     */
    @TableField("THIRD_PRICE")
    private BigDecimal thirdPrice;

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
     * 状态: 0未审核、1已审核
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
     * 最低消费
     */
    @TableField("MAX_QUOTE_PRICE")
    private BigDecimal maxQuotePrice;

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
     * 还柜加收
     */
    @TableField("CONTAINER_AMOUNT")
    private BigDecimal containerAmount;

    @TableField("QUOTE_SUPPLIER_TRANSPORT_ID_ARRAY")
    private String quoteSupplierTransportIdArray;

    @TableField("MD5_VALUE")
    private String md5Value;

    /**
     * 原id
     */
    @TableField("OLD_ID")
    private Integer oldId;

    /**
     * 中途地
     */
    @TableField("TRANSPORT_MIDWAY_ADDRESS")
    private String transportMidwayAddress;

    @TableField("UPDATE_DATE")
    private LocalDateTime updateDate;

    @TableField("UPDATE_USER_ID")
    private String updateUserId;

    @TableField("UPDATE_USER")
    private String updateUser;

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
