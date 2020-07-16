package com.mori.springboot;

import java.util.List;
import java.util.Optional;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.mori.springboot.repositories.MyDataMongoRepository;
import com.mori.springboot.repositories.MyDataRepository;

@Controller
public class HeloController {

	@Autowired
	MyDataRepository repository;

	@Autowired
	private MyDataService service;

	@Autowired
	MyDataBean myDataBean;

	@Autowired
	MyDataMongoRepository mongoRepository;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView index(ModelAndView mav) {
		mav.setViewName("index");
		mav.addObject("title", "Find Page");
		mav.addObject("msg", "MyDataMongoのサンプルです");
		Iterable<MyDataMongo> list = mongoRepository.findAll();
		mav.addObject("datalist", list);
		return mav;
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ModelAndView indexById( //
			@PathVariable long id, //
			ModelAndView mav //
	) {
		mav.setViewName("pickup");
		mav.addObject("title", "Pickup Page");
		String table = "<table>" //
				+ myDataBean.getTableTagById(id) //
				+ "</table>";
		mav.addObject("msg", "pickup data id = " + id);
		mav.addObject("data", table);
		return mav;
	}

	@RequestMapping(value = "/", method = RequestMethod.POST)
	@Transactional(readOnly = false)
	public ModelAndView form( //
			@RequestParam("name") String name, //
			@RequestParam("memo") String memo, //
			ModelAndView mav //
	) {
		MyDataMongo mydata = new MyDataMongo(name, memo);
		mongoRepository.save(mydata);
		return new ModelAndView("redirect:/");
	}

	@RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
	public ModelAndView edit( //
			@ModelAttribute("formModel") MyData mydata, //
			@PathVariable int id, //
			ModelAndView mav //
	) {
		mav.setViewName("edit");
		mav.addObject("title", "edit mydata");
		Optional<MyData> data = repository.findById((long) id);
		mav.addObject("formModel", data.get());
		return mav;
	}

	@RequestMapping(value = "/edit", method = RequestMethod.POST)
	@Transactional(readOnly = false)
	public ModelAndView update( //
			@ModelAttribute("formModel") MyData mydata, //
			ModelAndView mav //
	) {
		repository.saveAndFlush(mydata);
		return new ModelAndView("redirext:/");
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public ModelAndView delete( //
			@PathVariable int id, //
			ModelAndView mav //
	) {
		mav.setViewName("delete");
		mav.addObject("title", "delete mydata.");
		Optional<MyData> data = repository.findById((long) id);
		mav.addObject("formModel", data.get());
		return mav;
	}

	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	@Transactional(readOnly = false)
	public ModelAndView remove( //
			@RequestParam Long id, //
			ModelAndView mav //
	) {
		repository.deleteById(id);
		return new ModelAndView("redirext:/");
	}

	@RequestMapping(value = "/find", method = RequestMethod.GET)
	public ModelAndView find(ModelAndView mav) {
		mav.setViewName("find");
		mav.addObject("title", "Find Page");
		mav.addObject("msg", "MyDataのサンプルです");
		mav.addObject("value", "");
		List<MyDataMongo> list = mongoRepository.findAll();
		mav.addObject("datalist", list);
		return mav;
	}

	@RequestMapping(value = "/find", method = RequestMethod.POST)
	@Transactional(readOnly = false)
	public ModelAndView search( //
			@RequestParam("find") String param, //
			ModelAndView mav //
	) {
		mav.setViewName("find");
		if (param == "") {
			mav = new ModelAndView("redirect:/find");
		} else {
			mav.addObject("title", "Find result");
			mav.addObject("msg", "[" + param + "]の検索結果");
			mav.addObject("value", param);
			List<MyDataMongo> list = mongoRepository.findByName(param);
			mav.addObject("datalist", list);
		}
		return mav;
	}

	@RequestMapping(value = "/page", method = RequestMethod.GET)
	public ModelAndView index(ModelAndView mav, Pageable pageable) {
		mav.setViewName("index");
		mav.addObject("title", "Find Page");
		mav.addObject("msg", "MyDataのサンプルです");
		Page<MyData> list = repository.findAll(pageable);
		mav.addObject("datalist", list);
		return mav;
	}

	@PostConstruct
	public void init() {
		MyData d1 = new MyData();
		d1.setName("tsuyano");
		d1.setAge(123);
		d1.setMail("syoda@tsuyano.com");
		d1.setMemo("090999999");
		repository.saveAndFlush(d1);
		MyData d2 = new MyData();
		d2.setName("hanako");
		d2.setAge(15);
		d2.setMail("hanako@flower");
		d2.setMemo("080888888");
		repository.saveAndFlush(d2);
		MyData d3 = new MyData();
		d3.setName("sachiko");
		d3.setAge(37);
		d3.setMail("sachiko@happy");
		d3.setMemo("070777777");
		repository.saveAndFlush(d3);
	}
}

class DataObject {
	private int id;
	private String name;
	private String value;

	public DataObject(int id, String name, String value) {
		super();
		this.id = id;
		this.name = name;
		this.value = value;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
}
