package org.activiti.designer;

import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Map;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.activiti.engine.test.ActivitiRule;

import java.util.List;

public class DemoActivity {

	private String filename = "F:/Praveen data - review/Praveen/Company/WS/Learn/java-activi/src/main/resources/diagrams/MyProcess.bpmn";

	public static void main(String[] args) throws Exception{
		DemoActivity processTestMyProcess= new DemoActivity();
		processTestMyProcess.startProcess();
	}
	
	public void startProcess() throws Exception {
		//RepositoryService repositoryService = activitiRule.getRepositoryService();
		ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
		RepositoryService repositoryService = processEngine.getRepositoryService();
		repositoryService.createDeployment().addInputStream("myProcess.bpmn20.xml",
				new FileInputStream(filename)).deploy();
		//RuntimeService runtimeService = activitiRule.getRuntimeService();
		RuntimeService runtimeService = processEngine.getRuntimeService();
		Map<String, Object> variableMap = new HashMap<String, Object>();
		variableMap.put("name", "Activiti");
		ProcessInstance processInstance = runtimeService.startProcessInstanceByKey("myProcess", variableMap);
		System.out.println("id " + processInstance.getId() + " "
				+ processInstance.getProcessDefinitionId());
		TaskService taskService = processEngine.getTaskService();
		//List<Task> tasks = taskService.createTaskQuery().taskId("BPMNShape_usertask1").list();
		List<Task> tasks = taskService.createTaskQuery().list();
		Task task = tasks.get(0);
		System.out.println(task);
	}
}