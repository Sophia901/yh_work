package com.example.permission_service.controller;

import com.example.permission_service.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/rpc/permission")
public class RpcController {

    private final RoleService roleService;

    @Autowired
    public RpcController(RoleService roleService) {
        this.roleService = roleService;
    }


    /**
     * 角色绑定RPC接口
     * @param userId 用户ID
     * @return 绑定结果
     */
    @PostMapping("/bindDefaultRole")
    public ResponseEntity<Map<String, Object>> bindDefaultRole(@RequestParam Long userId) {
        try {
            roleService.bindDefaultRole(userId);
            return ResponseEntity.ok(Map.of(
                    "code", 200,
                    "message", "默认角色绑定成功",
                    "data", Map.of("userId", userId, "role", "user")
            ));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(Map.of(
                            "code", 500,
                            "message", "角色绑定失败: " + e.getMessage()
                    ));
        }
    }

    /**
     * 角色查询RPC接口
     * @param userId 用户ID
     * @return 角色编码
     */
    @GetMapping("/getUserRoleCode")
    public ResponseEntity<Map<String, Object>> getUserRoleCode(@RequestParam Long userId) {
        try {
            String roleCode = roleService.getUserRoleCode(userId);
            return ResponseEntity.ok(Map.of(
                    "code", 200,
                    "data", roleCode
            ));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(Map.of(
                            "code", 500,
                            "message", "角色查询失败: " + e.getMessage()
                    ));
        }
    }

}
