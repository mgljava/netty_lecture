package com.github.mgljava.protobuf.multi_protocol;

import com.github.mgljava.protobuf.multi_protocol.TaskProtocolWrapper.PackType;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import java.util.Objects;
import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class MultiProtocolClientHandler extends ChannelInboundHandlerAdapter {

  private ScheduledExecutorService executor = Executors.newSingleThreadScheduledExecutor();

  private AtomicInteger atomicInteger = new AtomicInteger(1);

  @Override
  public void channelActive(ChannelHandlerContext ctx) {
    executor.scheduleAtFixedRate(() -> {
      int packType = new Random().nextInt(3);
      switch (Objects.requireNonNull(PackType.forNumber(packType))) {
        case LOGIN:
          TaskProtocolWrapper.LoginPack loginPack = TaskProtocolWrapper.LoginPack.newBuilder()
              .setUsername("张三[" + atomicInteger.getAndIncrement() + "]").setPassword("123456").build();
          ctx.writeAndFlush(
              TaskProtocolWrapper.TaskProtocol.newBuilder().setPackType(TaskProtocolWrapper.PackType.LOGIN).setLoginPack(loginPack).build());
          break;
        case CREATE_TASK:
          TaskProtocolWrapper.CreateTaskPack createTaskPack = TaskProtocolWrapper.CreateTaskPack.newBuilder()
              .setCreateTime(System.currentTimeMillis()).setTaskId("100" + atomicInteger.get()).setTaskName("任务编号" + atomicInteger.get()).build();
          ctx.writeAndFlush(
              TaskProtocolWrapper.TaskProtocol.newBuilder().setPackType(TaskProtocolWrapper.PackType.CREATE_TASK).setCreateTaskPack(createTaskPack)
                  .build());
          break;
        case DELETE_TASK:
          TaskProtocolWrapper.DeleteTaskPack deleteTaskPack = TaskProtocolWrapper.DeleteTaskPack.newBuilder().addTaskId("1001").addTaskId("1002")
              .build();
          ctx.writeAndFlush(
              TaskProtocolWrapper.TaskProtocol.newBuilder().setPackType(TaskProtocolWrapper.PackType.DELETE_TASK).setDeleteTaskPack(deleteTaskPack)
                  .build());
          break;
        default:
          System.out.println("产生一个未知的包类型: " + packType);
          break;
      }

    }, 0, 2, TimeUnit.SECONDS);
  }

  @Override
  public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
    cause.printStackTrace();
    ctx.close();
  }
}
