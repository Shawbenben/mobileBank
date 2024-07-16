package ccnu.intern.mobilebanktest01.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 
 * </p>
 *
 * @author intern
 * @since 2024-07-15
 */
@Getter
@Setter
public class Dictype implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "dicTypeId", type = IdType.AUTO)
    private Integer dicTypeId;

    private Integer dicTypeCode;

    private String dicTypeName;


}
