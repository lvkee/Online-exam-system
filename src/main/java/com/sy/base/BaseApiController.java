package com.sy.base;


//import com.sy.context.WebContext;
import com.sy.util.ModelMapperSingle;
import org.modelmapper.ModelMapper;

/**
 * @description: The type Base api controller.
 */
public class BaseApiController {
    /**
     * The constant DEFAULT_PAGE_SIZE.
     */
    protected final static String DEFAULT_PAGE_SIZE = "10";
    /**
     * The constant modelMapper.
     */
    protected final static ModelMapper modelMapper = ModelMapperSingle.Instance();
    /**
     * The Web context.
     */
    /*@Autowired
    protected WebContext webContext;*/

    /**
     * Gets current user.
     *
     * @return the current user
     */
   /* protected User getCurrentUser() {
        return webContext.getCurrentUser();
    }*/
}
