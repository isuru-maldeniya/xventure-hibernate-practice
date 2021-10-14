package io.xventure.testing.xventurehibernatepractice.Channel.Service;

import io.xventure.testing.xventurehibernatepractice.Channel.Entity.Channel;
import io.xventure.testing.xventurehibernatepractice.Channel.Repository.ChannelRepository;
import io.xventure.testing.xventurehibernatepractice.Channel.dto.ChannelDTO;
import io.xventure.testing.xventurehibernatepractice.Doctor.Entity.Doctor;
import io.xventure.testing.xventurehibernatepractice.Doctor.Repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
public class ChannelService {

    @Autowired
    private ChannelRepository channelRepository;

    @Autowired
    private DoctorRepository doctorRepository;

    public ChannelDTO addChannel(ChannelDTO channelDTO){
        if(!doctorRepository.existsById(channelDTO.getDoctorId())){
            return null;
        }else{
            Doctor doctor = doctorRepository.findById(channelDTO.getDoctorId()).get();
            Channel save = channelRepository.save(new Channel(channelDTO.getId(), channelDTO.getStartTime(), channelDTO.getEndTime(), channelDTO.getDate(), channelDTO.getNumOfPatients(), 0,doctor ));
            return new ChannelDTO(save.getId(), save.getStartTime(),save.getEndTime(),save.getDate(), save.getNumOfPatients(), save.getFilledPatientsAmount(), save.getDoctor().getId());
        }
    }

    public ChannelDTO getChannelById(int id){
        if(!channelRepository.existsById(id)){
            return null;
        }else{
            Channel channel = channelRepository.findById(id).get();
            return new ChannelDTO(channel.getId(), channel.getStartTime(),channel.getEndTime(),channel.getDate(),channel.getNumOfPatients(), channel.getFilledPatientsAmount(), channel.getDoctor().getId());
        }
    }

    public List<ChannelDTO> getAllChannels(){
        List<ChannelDTO> channelDTOS=new LinkedList<>();
        channelRepository.findAll().forEach(channel -> channelDTOS.add(new ChannelDTO(channel.getId(), channel.getStartTime(),channel.getEndTime(),channel.getDate(), channel.getNumOfPatients(), channel.getFilledPatientsAmount(), channel.getDoctor().getId())));
        return channelDTOS;
    }

    public ChannelDTO updateChannel(int id, ChannelDTO channelDTO){
        if(!channelRepository.existsById(id)){
            return null;
        }else{
            Channel channel = channelRepository.findById(id).get();
            if(channelDTO.getDate()!=null){
                channel.setDate(channelDTO.getDate());
            }
            if(channelDTO.getStartTime()!=null){
                channel.setStartTime(channelDTO.getStartTime());
            }
            if(channelDTO.getEndTime()!=null){
                channel.setEndTime(channelDTO.getEndTime());
            }
            if(channelDTO.getNumOfPatients()!=0){
                channel.setNumOfPatients(channel.getNumOfPatients());
            }
            if(channelDTO.getFilledPatientsAmount()!=0){
                channel.setFilledPatientsAmount(channelDTO.getFilledPatientsAmount());
            }
            Channel save = channelRepository.save(channel);
            return new ChannelDTO(save.getId(), save.getStartTime(),save.getEndTime(),save.getDate(), save.getNumOfPatients(), save.getFilledPatientsAmount(), save.getDoctor().getId());
        }

    }


    public boolean deleteChannel(int id){
        if(!channelRepository.existsById(id)){
            return false;
        }else{
            channelRepository.deleteById(id);
            return true;
        }
    }
}
