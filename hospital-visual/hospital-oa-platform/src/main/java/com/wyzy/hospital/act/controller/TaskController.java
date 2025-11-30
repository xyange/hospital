

package com.wyzy.hospital.act.controller;

import cn.hutool.core.io.IoUtil;
import com.wyzy.hospital.act.dto.LeaveBillDto;
import com.wyzy.hospital.act.service.ActTaskService;
import com.wyzy.hospital.common.core.util.R;
import com.wyzy.hospital.common.security.annotation.Inner;
import com.wyzy.hospital.common.security.util.SecurityUtils;
import com.wyzy.hospital.common.xss.core.XssCleanIgnore;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.InputStream;
import java.util.Map;

/**
 * @author wyzy
 * @date 2018/9/28
 */
@RestController
@AllArgsConstructor
@RequestMapping("/task")
public class TaskController {

	private final ActTaskService actTaskService;

	@GetMapping("/todo")
	public R todo(@RequestParam Map<String, Object> params) {
		return R.ok(actTaskService.getTaskByName(params, SecurityUtils.getUser().getUsername()));
	}

	@GetMapping("/{id}")
	public R getTaskById(@PathVariable String id) {
		return R.ok(actTaskService.getTaskById(id));
	}

	@PostMapping
	@XssCleanIgnore
	public R submitTask(@RequestBody LeaveBillDto leaveBillDto) {
		return R.ok(actTaskService.submitTask(leaveBillDto));
	}

	@Inner(value = false)
	@GetMapping("/view/{id}")
	public ResponseEntity viewCurrentImage(@PathVariable String id) {
		InputStream imageStream = actTaskService.viewByTaskId(id);
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.IMAGE_PNG);
		return new ResponseEntity(IoUtil.readBytes(imageStream), headers, HttpStatus.CREATED);
	}

	@GetMapping("/comment/{id}")
	public R commitList(@PathVariable String id) {
		return R.ok(actTaskService.getCommentByTaskId(id));
	}

}
