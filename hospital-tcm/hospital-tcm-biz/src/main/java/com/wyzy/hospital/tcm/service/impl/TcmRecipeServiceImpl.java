
package com.wyzy.hospital.tcm.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wyzy.hospital.common.core.util.CodeMsg;
import com.wyzy.hospital.common.core.util.R;
import com.wyzy.hospital.tcm.dto.TcmRecipeDTO;
import com.wyzy.hospital.tcm.entity.TcmRecipe;
import com.wyzy.hospital.tcm.entity.TcmRecipesuper;
import com.wyzy.hospital.tcm.exception.GlobalException;
import com.wyzy.hospital.tcm.mapper.TcmRecipeMapper;
import com.wyzy.hospital.tcm.service.TcmRecipeService;
import com.wyzy.hospital.tcm.service.TcmRecipesuperService;
import com.wyzy.hospital.tcm.utils.DateTimeUtil;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

/**
 * 方剂表
 *
 * @author hospital code generator
 * @date 2021-04-24 14:16:31
 */
@Service
public class TcmRecipeServiceImpl extends ServiceImpl<TcmRecipeMapper, TcmRecipe> implements TcmRecipeService {
	@Resource
	private  TcmRecipeMapper   testMapper;

	/**
	 * 分页
	 * @param page
	 * @return
	 */
	@Override
	public IPage<TcmRecipeDTO> pageTcmRecipeDTO(IPage<TcmRecipeDTO> page) {
		List<TcmRecipeDTO> tcmRecipeList = testMapper.selectAllDTO(page);
		IPage<TcmRecipeDTO> tcmRecipeIPage = page.setRecords(tcmRecipeList);
		return tcmRecipeIPage;
	}

	/**
	 * APP分页
	 * @param page
	 * @return
	 */
	@Override
	public IPage<TcmRecipeDTO> pageTcmRecipeDTOAPP(IPage<TcmRecipeDTO> page) {
		List<TcmRecipeDTO> tcmRecipeList = testMapper.selectAllDTOAPP(page);
		IPage<TcmRecipeDTO> tcmRecipeIPage = page.setRecords(tcmRecipeList);
		return tcmRecipeIPage;
	}

	/**
	 * 修改方剂表
	 * @param tcmRecipe 方剂表
	 * @return R
	 */
	@Override
	public boolean updatePojoById(TcmRecipe tcmRecipe) {
		tcmRecipe.setIsOnline(0);
		tcmRecipe.setDelFlag(0);
		tcmRecipe.setUpdateTime(DateTimeUtil.returnLocalDateTime());
		return baseMapper.updatePojoById(tcmRecipe);
	}

	/**
	 * 根据父级ID查询方剂表集合列表
	 * @param recipesuperId
	 * @return
	 */
	@Override
	public List<TcmRecipeDTO> selectTcmRecipeByrecipesuperId(Long recipesuperId) {
		List<TcmRecipeDTO> tcmRecipeList = testMapper.selectTcmRecipeByrecipesuperId(recipesuperId);
		return tcmRecipeList;
	}

	/**
	 * 根据父级ID查询方剂表集合列表，所有
	 * @param id
	 * @return
	 */
	@Override
	public List<TcmRecipeDTO> selectAllTcmRecipeByrecipesuperId(Long id) {
		List<TcmRecipeDTO> tcmRecipeList = testMapper.selectAllTcmRecipeByrecipesuperId(id);
		return tcmRecipeList;
	}

	/**
	 * 通过id查询方剂表
	 * @param recipeId id
	 * @return R
	 */
	@Override
	public TcmRecipeDTO getById(Long recipeId) {
		return baseMapper.getById(recipeId);
	}

	/**
	 * 通过name查询方剂表
	 * @param name
	 * @return R
	 */
	@Override
	public TcmRecipeDTO selectTcmRecipeDTOByName(String name) {
		TcmRecipeDTO recipeDTO = baseMapper.selectTcmRecipeDTOByName(name);
		return recipeDTO;
	}

	/**
	 * 新增方剂表
	 * @param tcmRecipe 方剂表
	 * @return R
	 */
	@Override
	public boolean saveTcmRecipe(TcmRecipe tcmRecipe) {
			TcmRecipe recipe = baseMapper.selectTcmRecipeByName(tcmRecipe.getRecipeName());
			if (recipe != null){
				throw new GlobalException(CodeMsg.THE_NAME_ALREADY_EXISTS);
			}
			int insert = baseMapper.insert(tcmRecipe);
			if (insert > 0){
				return true;
			}else {
				return false;
			}
	}

	/**
	 * 查询所有数据
	 * @return
	 */
	@Override
	public List<TcmRecipe> selectAll() {
		List<TcmRecipe> recipeList = baseMapper.selectAll();
		if (recipeList == null ||recipeList.size() == 0){
			return null;
		}
		return recipeList;
	}

	@Override
	public boolean goOnlineById(Long recipeId, Integer isOnline) {
		if (isOnline == 0){
			isOnline = 1 ;
		}else if (isOnline == 1){
			isOnline = 0 ;
		}
		int i = baseMapper.updateTcmRecipeById(recipeId,isOnline);
		if (i>0){
			return true;
		}
		return false;
	}
}
