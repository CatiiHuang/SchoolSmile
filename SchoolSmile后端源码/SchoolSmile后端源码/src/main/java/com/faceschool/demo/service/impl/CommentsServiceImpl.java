package com.faceschool.demo.service.impl;

import com.faceschool.demo.entity.Comments;
import com.faceschool.demo.mapper.CommentsMapper;
import com.faceschool.demo.service.ICommentsService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Fyly
 * @since 2019-04-19
 */
@Service
public class CommentsServiceImpl extends ServiceImpl<CommentsMapper, Comments> implements ICommentsService {

}
