package com.example.demo.api;

import com.example.demo.domain.Customer;
import com.example.demo.service.CustomerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.awt.print.Pageable;
import java.util.List;
import java.util.Optional;

// RESTWebサービスのエンドポイントになるControllerクラス
@RestController
// 本RESTWebサービスへのアクセスパスの設定
@RequestMapping("/api/customers")
public class CustomerRestController {
	@Autowired
	CustomerService customerService;
	
	// 顧客全件取得
	/*
	 *  HTTPメソッドの、/api/customersへのGETの割当
	 *  以下アノテーションを指定したメソッドの戻り値はシリアライズされて、レスポンスのbodyに設定
	 *  デフォルトでは、JavaオブジェクトはJSON形式でシリアライズされる
	 */
	@GetMapping
	/*
	 * 引数にPageableオブジェクトを追加することでページネーションの情報を取得できる
	 * リクエストパラメータに設定したpage、sizeがPageableオブジェクトにマッピングされる
	 * パラメータ未指定の場合のデフォルト値を設定するため、@PageableDefaultアノテーションを指定
	 * @PageableDefaultアノテーションにpageやsizeのデフォルト値を指定できるが、未指定の場合はpage=0、size=20が設定される
	 */
	List<Customer> getCustomers(@PageableDefault Pageable pageable) {
		// 
		List<Customer> customers = customerService.findAll();
		return customers;
	}
	
	// 顧客1件取得
	/*
	 * HTTPメソッドの、/api/customers/{id}へのGETの割当
	 * pathに指定したプレースホルダのパラメータはメソッドの引数で取得できる
	 * 対象の引数に@PathVariableアノテーションを付与する
	 * (引数名とプレースホルダの値を一致させる必要)
	 */
	@GetMapping(path = "{id}")
	Optional<Customer> getCustomer(@PathVariable Integer id) {
		Optional<Customer> customer = customerService.findOne(id);
		return customer;
	}
	
	// HTTPメソッドの、/api/customersへの POSTの割当
	@PostMapping
	// APIの正常時のHTTPレスポンスを設定。未設定の場合は200 OKが返る
	@ResponseStatus(HttpStatus.CREATED)
	Customer postCustomer(@RequestBody Customer customer) {
		return customerService.update(customer);
	}
	
/*
 * HTTPレスポンスのlocationヘッダにURIを設定する
 * 	@PostMapping
 *  コンテキストパス相対のURIを構築するのに便利なUriComponentsBuilderをコントローラの引数に指定する
 *	ResponseEntity<Customer> postCustomers(@RequestBody Customer customer, UriComponentsBuilder uriBuilder){
 *		Customer created = customerService.create(customer);
 *   UriComponentsBuilderがCustomerオブジェクトを用いてリソースのURIを作成する
 *   pathメソッド内の{id}はプレースホルダで、buildAndExpandメソッドに渡す値に変換される
 *		URI location = uriBuilder.path("api/customers/{id}")
 *				.buildAndExpand(created.getId())
 *				.toUri();
 *   HTTPレスポンスヘッダを設定したい場合はResponseEntityオブジェクトをreturnする
 *   ResponseEntityオブジェクトには、レスポンスボディであるCustomerオブジェクト、
 *   レスポンスヘッダであるHttpHeadersオブジェクト、ステータスコードであるHttpStatusを設定する
 *		return ResponseEntity.created(location).body(created);
 *	}
*/	
	// HTTPメソッドの、/api/customers/{id}へのPUTの割当
	@PutMapping(path = "{id}")
	Customer putCustomer(@PathVariable Integer id, @RequestBody Customer customer) {
		customer.setId(id);
		return customerService.update(customer);
	}
	
	// HTTPメソッドの、/api/customers/{id}へのDELETEの割当
	@DeleteMapping(path = "{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
		void deleteCustomer(@PathVariable Integer id) {
			customerService.delete(id);
		}
}
