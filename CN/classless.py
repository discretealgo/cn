def main():
    ip_input = input('Enter IP in this format 106.255.255.6/24: ')
    ip, mask_size = ip_input.split('/')
    mask = int(mask_size)
    
    # Convert IP address to binary
    ip_split = [bin(int(x)).replace("0b", '').rjust(8, '0') for x in ip.split('.')]
    binary_ip = ''.join(ip_split)
    
    # Calculate network address
    net_id_bin = binary_ip[:mask] + '0' * (32 - mask)
    net_id = [str(int(net_id_bin[i:i+8], 2)) for i in range(0, 32, 8)]
    net_id_str = '.'.join(net_id)
    
    # Calculate host address
    host_id_bin = '0' * mask + binary_ip[mask:]
    host_id = [str(int(host_id_bin[i:i+8], 2)) for i in range(0, 32, 8)]
    host_id_str = '.'.join(host_id)
    
    print(f"IP Address: {ip}")
    print(f"Subnet Mask: /{mask}")
    print(f"Network ID: {net_id_str}")
    print(f"Host ID: {host_id_str}")

if __name__ == "__main__":
    main()
